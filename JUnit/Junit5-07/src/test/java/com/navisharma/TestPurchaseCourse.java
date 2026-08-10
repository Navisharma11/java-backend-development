package com.navisharma;

import com.learning.dao.JavaCourse;
import com.navisharma.service.PurchaseCourse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPurchaseCourse
{
    @Test
    void testproceedWithCourse()
    {
        PurchaseCourse pc = new PurchaseCourse();
        boolean status = pc.proceedWithCourse(new JavaCourse());
//        assertTrue(status);
        assertFalse(status,"Its failed because unit is results in false");
    }
}