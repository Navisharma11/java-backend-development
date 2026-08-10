package com.navisharma.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest
{
    ReverseString reverse = new ReverseString();
    @Test
    void testReverseString_OneWord()
    {
        assertEquals("avaJ", reverse.reverseString("Java"));
    }

    @Test
    void testReverseString_MultipleWords()
    {
        assertEquals("ysae si avaJ", reverse.reverseString("Java is easy"));
    }

}
