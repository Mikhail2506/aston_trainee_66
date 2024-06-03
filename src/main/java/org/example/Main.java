package org.example;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CustomArrayList<Integer> list = new CustomArrayList<>(5);
        list.add(10);
        list.add(2);
        list.add(6);
        list.add(4);
        list.add(9);
        list.add(54);
        list.add(7);
        System.out.println(list.toString());

        QuickSort.quickSort(list, Comparator.reverseOrder());
        System.out.println(list.toString());
        QuickSort.quickSort(list);
        System.out.println(list.toString());
    }
}