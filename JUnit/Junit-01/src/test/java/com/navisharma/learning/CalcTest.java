package com.navisharma.learning;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest
{
    @Test
    public void test()
    {
        Calc c = new Calc();
        int actual = c.divide(10,5);
        int expectedResult = 2;
        assertEquals(expectedResult,actual);
    }

}