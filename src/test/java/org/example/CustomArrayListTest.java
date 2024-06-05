package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class CustomArrayListTest {

    private String[] internalArray;
    private CustomArrayList<String> customArrayList;

    @BeforeEach
    void setUp() {
        customArrayList = new CustomArrayList<>();
    }

    @Test
    void testConstructorWithDefaultCapacity() {
        try {
            Field field = CustomArrayList.class.getDeclaredField("DEFAULT_CAPACITY");
            field.setAccessible(true);
            Assertions.assertEquals(10, field.getInt("10"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
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
    }

    @Test
    void testSet() {
        customArrayList.add("element1");
        customArrayList.add("element2");
        Assertions.assertEquals("element1", customArrayList.set(0, "newElement1"));
        Assertions.assertEquals("newElement1", customArrayList.get(0));
        Assertions.assertEquals("element2", customArrayList.get(1));
    }

    @Test
    void testAddAtIndex() {
        customArrayList.add("element1");
        customArrayList.add("element2");
        customArrayList.add(1, "newElement");
        Assertions.assertEquals("element1", customArrayList.get(0));
        Assertions.assertEquals("newElement", customArrayList.get(1));
        customArrayList.add(2, "newElement");
        Assertions.assertEquals("newElement", customArrayList.get(2));
    }

    @Test
    void testRemove() {
        customArrayList.add("element1");
        customArrayList.add("element2");
        customArrayList.add("element3");
        Assertions.assertEquals("element2", customArrayList.remove(1));
        Assertions.assertEquals("element1", customArrayList.get(0));
        Assertions.assertEquals("element3", customArrayList.get(1));
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