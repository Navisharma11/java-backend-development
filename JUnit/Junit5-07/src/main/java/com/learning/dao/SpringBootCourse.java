package com.learning.dao;

public class SpringBootCourse implements Course
{
    @Override
    public boolean coursePurchased() {
        System.out.println("SpringBootCourse Course Purchased");
        return true;
    }
}
