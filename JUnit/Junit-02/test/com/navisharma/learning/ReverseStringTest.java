package com.navisharma.learning;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest
{
    @Test(timeout=100)
    public void test()
    {
        ReverseString reverse = new ReverseString();
        assertEquals("avaJ", reverse.reverseString("Java"));
    }
}
