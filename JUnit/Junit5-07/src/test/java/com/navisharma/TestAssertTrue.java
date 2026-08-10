package com.navisharma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAssertTrue
{
    @Test
    void test()
    {
//        String str = "Junit";
//        assertTrue(str.equals("Junit"));

        String str = "Junit5";
        assertFalse(str.length()<5);

    }
}
