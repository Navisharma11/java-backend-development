package com.learning.dao;

public class JavaCourse implements Course
{
    @Override
    public boolean coursePurchased() {
        System.out.println("Java Course Purchased");
        System.out.println("Its not actually connecting to db hence result in false");
        return false;
    }
}
