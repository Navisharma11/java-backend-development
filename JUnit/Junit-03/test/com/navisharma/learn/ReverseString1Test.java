package com.navisharma.learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseString1Test
{
    @Test
    public void test()
    {
        ReverseString1 reverse = new ReverseString1();
        assertEquals("avaJ", reverse.reverseString("Java"));
        assertEquals("ivaN",reverse.reverseString("Navi"));
    }

}