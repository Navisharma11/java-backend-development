package com.navisharma.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShapesTest
{
    @Test
    void test()
    {
        assertEquals(6,6);
    }

    @Test
    void testComputeSquareArea()
    {
        Shapes shape = new Shapes();
        assertEquals(576,shape.computeSquareArea(24));

    }


    @Test
    void testComputeCircleArea_WithMessage()
    {
        Shapes shape = new Shapes();
        assertEquals(78.5,shape.computeCircleArea(5),"Area of circle calculation is wrong");
    }


    @Test
    void testComputeCircleArea_Supplier()   //Using supplier functional interface
    {
        Shapes shape = new Shapes();
        assertEquals(7.5,shape.computeCircleArea(5),()->"Area of circle calculation is wrong");
    }
}
