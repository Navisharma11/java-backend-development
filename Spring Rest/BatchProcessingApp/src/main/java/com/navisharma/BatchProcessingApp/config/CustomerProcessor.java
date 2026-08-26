package com.navisharma.BatchProcessingApp.config;

import com.navisharma.BatchProcessingApp.model.Customer;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.infrastructure.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer>
{


    @Override
    public @Nullable Customer process(Customer item) throws Exception {
        //logic to process
        return item;
    }
}
