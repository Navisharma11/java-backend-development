package com.navisharma.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShapesTest2
{
    Shapes shape = new Shapes();

    @Test
    void testComputeSquareArea()
    {

        assertNotEquals(576,shape.computeSquareArea(24));

    }


    @Test
    void testComputeSquareArea_WithMessage()
    {
        assertNotEquals(576,shape.computeSquareArea(24),"Msg to dev if testcase fail");
    }



    @Test
    void testComputeSquareArea_Supplier()
    {
        assertNotEquals(576,shape.computeSquareArea(24),()->"Msg to dev if testcase fail");
    }

}
