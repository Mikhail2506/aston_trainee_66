package org.example;

import java.util.Comparator;

/**
 * Class QuickSort is a custom realization for quick sort methods for CustomArrayList using Comparable and Comparator.
 * In case of using Comparable quicksort method parameter type T need to extend interface Comparable.
 *In case of using Comparator quicksort method parameter Comparator need to be included to the method.
 * All the methods of this class are static.
 * @author Mikhail Toukach
 * @version 1.0
 * @since 2024-06-02
 * @param <T> This describes using type of parameter, need to be extended interface comparable
 */
public class QuickSort {
    /**
     * QuickSort method using Comparable.
     * @param list CustomArrayList to be sorted.
     * @param <T> Type of elements of the sorted list, need to extend Comparable.
     */
    public static <T extends Comparable<T>> void quickSort(CustomArrayList<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void quickSort(CustomArrayList<T> list, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, left, right);
            quickSort(list, left, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(CustomArrayList<T> list, int left, int right) {
        T pivot = list.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, right);
        return i + 1;
    }

    /**
     * QuickSort method using Comparator.
     * @param list List of sorting elements.
     * @param comparator
     * @param <T>
     */
    public static <T> void quickSort(CustomArrayList<T> list, Comparator<T> comparator) {
        quickSort(list, comparator, 0, list.size() - 1);
    }

    private static <T> void quickSort(CustomArrayList<T> list, Comparator<T> comparator, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, comparator, left, right);
            quickSort(list, comparator, left, pivotIndex - 1);
            quickSort(list, comparator, pivotIndex + 1, right);
        }
    }

    private static <T> int partition(CustomArrayList<T> list, Comparator<T> comparator, int left, int right) {
        T pivot = list.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (comparator.compare(list.get(j), pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, right);
        return i + 1;
    }

    private static <T> void swap(CustomArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
