package com.navisharma;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class TestPerformance
{
    @Test
    void testSortingMethod_Performance()
    {
        SortingArray array = new SortingArray();

        int unsorted[] = {2,5,1};

        assertTimeout(Duration.ofMillis(10),()->array.sortingArray(unsorted));

    }
}
