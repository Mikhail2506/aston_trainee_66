package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class QuickSortTest {


    private CustomArrayList<Integer> list;
    private CustomArrayList<String> list2;
    private CustomArrayList<Integer> list3;

    @BeforeEach
    void setUp() {
        list = new CustomArrayList<>(10);
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            list.add(random.nextInt(10));
        }

        list2 = new CustomArrayList<>(5);
        list2.add("apple");
        list2.add("banana");
        list2.add("cherry");
        list2.add("date");
        list2.add("elderberry");

        list3 = new CustomArrayList<>(10);
        list3.add(2);
        list3.add(1);
        list3.add(9);
        list3.add(10);
        list3.add(4);
        list3.add(8);
        list3.add(5);
        list3.add(6);
        list3.add(7);
        list3.add(3);
    }

    @Test
    @DisplayName("Test quick sort method that uses the Comparable interface with empty list")
    void testQuickSortComparableWithEmptyList() {
        QuickSort.quickSortComparable(list);
        Assertions.assertFalse(list.isCustomArrayListEmpty());
    }

    @Test
    @DisplayName("Test for the quick sorting method that uses the Comparable interface for CustomArrayList with Integers")
    void testQuickSortComparableWithIntegerList() {
        QuickSort.quickSortComparable(list);
        Assertions.assertTrue(isSorted(list));
    }

    @Test
    @DisplayName("Test for the quick sorting method that uses the Comparable interface for CustomArrayList with String")
    void testQuickSortComparableWithStringList() {
        QuickSort.quickSortComparable(list2);
        Assertions.assertTrue(isSorted(list2));
    }

    private <T extends Comparable<T>> boolean isSorted(CustomArrayList<T> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testQuickSortComparatorWithIntegerComparator() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        QuickSort.quickSortComparator(list3, comparator);
        Integer[] expectedList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assertions.assertEquals(Arrays.toString(expectedList), Arrays.toString(list3.toArray()));
    }

    @Test
    void testQuickSortComparatorWithStringComparator() {
        Comparator<String> comparator = Comparator.naturalOrder();
        QuickSort.quickSortComparator(list2, comparator);
        String[] expectedList = {"apple", "banana", "cherry", "date", "elderberry"};
        Assertions.assertEquals(Arrays.toString(expectedList), Arrays.toString(list2.toArray()));
    }
}