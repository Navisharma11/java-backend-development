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

        Employee emp1 = container.getBean(Employee.class);
        System.out.println(emp1);
        System.out.println(emp1.employeeTask());



    }
}
