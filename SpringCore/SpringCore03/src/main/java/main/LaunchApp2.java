package main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp2
{
    public static void main(String[] args)
    {
        //BeanFactory
        //ApplicationContext

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions("applicationconfig.xml");
        reader.loadBeanDefinitions("applicationconfig2.xml");

//        Telusko t = beanFactory.getBean(Telusko.class);
//
//        Boolean status = t.buyTheCourse(4545.5);
//        if(status)
//            System.out.println("Course Enrolled Successfully");
//        else
//            System.out.println("Failed to enroll for the course");
    }
}
