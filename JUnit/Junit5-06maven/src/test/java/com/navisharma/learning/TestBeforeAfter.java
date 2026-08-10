package com.navisharma.learning;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)   //By this instance of this class is created only once
public class TestBeforeAfter
{
    TestBeforeAfter()
    {
        System.out.println("Test obj is created before test method");
    }


    // for without @TestInstance lifecycle.perclass does use static
//    @BeforeAll
//    static void beforeAll()
//    {
//        System.out.println("Before all test");
//    }
//
//    @AfterAll
//    static void afterAll()
//    {
//        System.out.println("After all test");
//    }



//     for using TestInstance lifecycle.perclass does not use static
    @BeforeAll
    void beforeAll()
    {
        System.out.println("Before all test");
    }

    @AfterAll
    void afterAll()
    {
        System.out.println("After all test");
    }

    Shapes shape;

    @BeforeEach
    void init()
    {
        shape = new Shapes();
        System.out.println("Before test");
    }

    @Test
    void testComputeSquareArea()
    {
        assertEquals(576,shape.computeSquareArea(24));
        System.out.println("Actual test running");
    }


    @Test
    void testComputeCircleArea()
    {
        assertEquals(78.5,shape.computeCircleArea(5));
        System.out.println("Actual test running");
    }


    @AfterEach
    void destroy()
    {
        System.out.println("After test clean up");
    }

}
