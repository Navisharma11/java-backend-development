package com.navisharma.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapesTest
{
    Shapes shape = new Shapes();

    @Test
    void testComputeSquareArea()
    {
        assertEquals(576,shape.computeSquareArea(24));
    }


    @Test
    void testComputeCircleArea()
    {
        assertEquals(78.5,shape.computeCircleArea(5), "Area of circle calculation is wrong");
    }
}
