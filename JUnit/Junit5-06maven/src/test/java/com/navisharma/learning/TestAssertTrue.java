package com.navisharma.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAssertTrue
{
    @Test
    void test()
    {
        String str = "Junit";
        assertTrue(str.equals("Junit"));
    }
}
