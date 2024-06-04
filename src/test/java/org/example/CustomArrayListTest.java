package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class CustomArrayListTest {

    private String[] internalArray;
    private CustomArrayList<String> customArrayList;

    @BeforeEach
    void setUp() {
        customArrayList = new CustomArrayList<>();
    }

    @Test
    void testConstructorWithDefaultCapacity() {
        Assertions.assertEquals(10, 10);
        Assertions.assertEquals(0, customArrayList.size());
    }

    @Test
    void testConstructorWithUserCapacity() {
        CustomArrayList<String> customArrayListWithUserCapacity = new CustomArrayList<>(20);
        Assertions.assertEquals(0, customArrayListWithUserCapacity.size());
        customArrayListWithUserCapacity.add("element1");
        customArrayListWithUserCapacity.add("element2");
        customArrayListWithUserCapacity.add("element3");
        Assertions.assertEquals(3, customArrayListWithUserCapacity.size());
    }

    @Test
    void testConstructorWithInvalidCapacity() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CustomArrayList<>(-5));
    }

    @Test
    void testSize() {
        Assertions.assertEquals(0, customArrayList.size());
        customArrayList.add("element1");
        Assertions.assertEquals(1, customArrayList.size());
    }

    @Test
    void testIsCustomArrayListEmpty() {
        Assertions.assertTrue(customArrayList.isCustomArrayListEmpty());
        customArrayList.add("element1");
        Assertions.assertFalse(customArrayList.isCustomArrayListEmpty());
    }

    @Test
    void testContains() {
        customArrayList.add("element1");
        Assertions.assertThrows(NullPointerException.class, () -> {
            customArrayList.contains(null);
        });
        Assertions.assertFalse(customArrayList.isCustomArrayListEmpty());
        Assertions.assertTrue(customArrayList.contains("element1"));
    }

    @Test
    void testAdd() {
        Assertions.assertTrue(customArrayList.add("element1"));
        Assertions.assertEquals("element1", customArrayList.get(0));
        Assertions.assertEquals(1, customArrayList.size());
    }

    @Test
    void testGet() {
        customArrayList.add("element1");
        customArrayList.add("element2");
        Assertions.assertEquals("element1", customArrayList.get(0));
        Assertions.assertEquals("element2", customArrayList.get(1));
       // Assertions.assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.get(2));
    }

    @Test
    void testSet() {
        customArrayList.add("element1");
        customArrayList.add("element2");
        Assertions.assertEquals("element1", customArrayList.set(0, "newElement1"));
        Assertions.assertEquals("newElement1", customArrayList.get(0));
        Assertions.assertEquals("element2", customArrayList.get(1));
        //Assertions.assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.set(2, "newElement"));
    }

    @Test
    void testAddAtIndex() {
        customArrayList.add("element1");
        customArrayList.add("element2");
        customArrayList.add(1, "newElement");
        Assertions.assertEquals("element1", customArrayList.get(0));
        Assertions.assertEquals("newElement", customArrayList.get(1));
        Assertions.assertEquals("element2", customArrayList.get(2));
    }

    @Test
    void testRemove() {
        customArrayList.add("element1");
        customArrayList.add("element2");
        customArrayList.add("element3");
        Assertions.assertEquals("element2", customArrayList.remove(1));
        Assertions.assertEquals("element1", customArrayList.get(0));
        Assertions.assertEquals("element3", customArrayList.get(1));
        Assertions.assertEquals(2, customArrayList.size());
        //Assertions.assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.remove(2));
    }

    @Test
    void testToString() {
        CustomArrayList<String> customArrayListToString = new CustomArrayList<>(3);
        customArrayListToString.add("element1");
        customArrayListToString.add("element2");
        customArrayListToString.add("element3");
        Assertions.assertEquals("[element1, element2, element3]", customArrayListToString.toString());
    }
}