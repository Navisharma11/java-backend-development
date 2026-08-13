package com.navisharma.RestApiUnitTesting.service;

import com.navisharma.RestApiUnitTesting.model.Student;

public interface IGreetings
{
    String generateWish(String name);
    Boolean addStudent(Student st);
}