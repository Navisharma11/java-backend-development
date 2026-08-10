package com.navisharma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class TestException
{
    @Test
    void testSortingArray_Exception() {
//        try
//        {
        SortingArray array = new SortingArray();
//            int unsorted[] = {5,4,2};
//            int sortedArray[] = array.sortingArray(unsorted);
//        for(int elem:sortedArray)
//        {
//            System.out.print(elem);
//        }
//            System.out.println("System below exception");
//        fail();
//        }
//        catch(NullPointerException e)
//        {
//            System.out.println("Exception generated");
//        }
//    }

        int unsorted[] = null;
        assertThrows(NullPointerException.class, () -> array.sortingArray(unsorted));
    }
}
