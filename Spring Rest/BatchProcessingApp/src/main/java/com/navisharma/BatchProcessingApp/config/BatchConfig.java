package com.navisharma.BatchProcessingApp.config;

import com.navisharma.BatchProcessingApp.dao.ICustomerRepo;
import com.navisharma.BatchProcessingApp.model.Customer;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.data.RepositoryItemWriter;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.LineMapper;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.infrastructure.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.infrastructure.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig
{
    @Autowired
    private ICustomerRepo repo;

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private PlatformTransactionManager transactionManager;
    //ItemReader

    @Bean
    public FlatFileItemReader<Customer> itemReader()
    {
        FlatFileItemReader<Customer> reader = new FlatFileItemReader<>(new ClassPathResource("customer_data_200.csv"), lineMapper());
//        reader.setResource(new FileSystemResource("src/main/resources/customer_data_200.csv"));  //localtion of csv file
        reader.setName("csv-reader"); // skip the header
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());
        return reader;
    }

    private LineMapper<Customer> lineMapper()
    {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");// read from csv file which is , separated file
        tokenizer.setStrict(false);//If some of the record some of the column dont have data ignore that
        tokenizer.setNames("customerID","firstName","lastName","email","phoneNumber","city","state","zipcode","country"); //read all these columns
        BeanWrapperFieldSetMapper<Customer> beanWrapper = new BeanWrapperFieldSetMapper<>();  //these columns bind to the customer class
        beanWrapper.setTargetType(Customer.class); //Set Target which we have to map with like which pojo or model
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(beanWrapper);
        return lineMapper;
    }


    //ItemProcessor
    @Bean
    public CustomerProcessor processCxData()
    {
        return new CustomerProcessor();   //processing the data
    }


    //ItemWriter
    @Bean
    public RepositoryItemWriter<Customer> itemWriter()
    {
        RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>(repo);   // writing into database using repo
//        writer.setRepository(repo);
        writer.setMethodName("save");   // using the save method
        return writer;
    }


    //Step
    @Bean
    public Step step()
    {
        return new StepBuilder("step-1",jobRepo).<Customer,Customer>  //"Create a Step called step-1, process Customer objects in chunks of 10, read them using my ItemReader, process them using my CustomerProcessor, write them using my ItemWriter, and use the JobRepository to maintain execution metadata."
                chunk(10)
                .reader(itemReader())
                .processor(processCxData())
                .writer(itemWriter())
                .build();
    }



    //Job
    @Bean
    public Job job()
    {
        return new JobBuilder("customer-import",jobRepo)
                .start(step())
                .build();

    }


}
