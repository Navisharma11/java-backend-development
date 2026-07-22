package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Employee;

public class LaunchApp1
{
    public static void main(String[] args)
    {
        //BeanFactory
        //ApplicationContext

        ApplicationContext container = new ClassPathXmlApplicationContext("applicationconfig.xml");

        Employee emp1 = container.getBean("emp1",Employee.class);
        System.out.println(emp1);
        System.out.println(emp1.employeeTask());

        System.out.println("****************************");

        Employee emp2 = container.getBean("emp2", Employee.class);
        System.out.println(emp2);
        System.out.println(emp2.employeeTask());

    }
}
