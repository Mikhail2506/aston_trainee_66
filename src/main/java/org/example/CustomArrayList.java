package org.example;

/**
 * Class CustomArrayList is a custom implementation of a Dynamic array.
 * Resizable-array implementation of the common ArrayList class methods.
 * Implements most common used ArrayList operations, and permits all elements, including null.
 * This class provides methods to manipulate the size of the array that is used internally to store the Objects.
 * It is not synchronized.
 * Each CustomArrayList instance has a capacity. The capacity is the size of the array used to store the elements in the list.
 * It is always as large as the list size. As elements are added to an ArrayList, its capacity grows automatically.
 * An application can increase the capacity of an ArrayList instance before adding a large number of elements using the ensureCapacity operation.
 * This class is a custom, it is not belongs to the Java Collections Framework.
 * @author Mikhail Toukach
 * @version 1.0
 * @since 2024-06-02
 * @param <T> This describes using type of parameter
 */
public class CustomArrayList<T> {

    private T[] internalArray;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public CustomArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     *  Constructs an empty list with the specified initial capacity.
     */
    public CustomArrayList(T[] internalArray) {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     * @param usersCapacity Indicates number of elements in the list.
     *@exception IllegalArgumentException To be thrown in case of negative number of elements specified by user.
     */
    public CustomArrayList(int usersCapacity) {
        if (usersCapacity < 0) {
            throw new IllegalArgumentException("The capacity of Your CustomArrayList must be positive number!");
        } else {
            this.internalArray = (T[]) new Object[usersCapacity];
            this.size = 0;
        }
    }

    /**
     *Returns the number of elements in this list.
     * @return Returning type is int.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     * @return Returning type is boolean.
     */
    public boolean isCustomArrayListEmpty() {
        return (size == 0);
    }

    /**
     * Returns true if this list contains the specified element.
     * @param lookingForElement Is element to be looking for.
     * @return Returning type is boolean.
     */
    public boolean contains(T lookingForElement) {
        boolean flag = false;
        if (!isCustomArrayListEmpty()) {
            for (T element : internalArray) {
                if (element.equals(lookingForElement)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * appends the specified element to the end of this list.
     * Returns true in positive case.
     * If the size of the list is not enough increases it.
     * @param element Adding element.
     * @return Returning type is boolean.
     */
    public boolean add(T element) {
        if (size == internalArray.length) {
            resize();
        }
        internalArray[size++] = element;
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index Position of the element to be got.
     * @return Returning type of the element to be got.
     */
    public T get(int index) {
        if (checkIndex(index)) {
            return internalArray[index];
        } else {
            return null;
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * In case the index is presented in the list.
     * @param index Position to be inserted the element.
     * @param element Element to be inserted.
     * @return replaced element.
     */
    public T set(int index, T element) {
        checkIndex(index);
        T oldElement = internalArray[index];
        internalArray[index] = element;
        return oldElement;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Empty indexes are not allowed
     * In case the size of the list is not enough increases it.
     * @param index Position of the element to be added.
     * @param element The element to be added.
     */
    public void add(int index, T element) {
        if (checkIndex(index)) {
            T[] tempArray;
            if (this.size == 0) {
                internalArray[0] = element;
            } else if (index < size) {
                tempArray = (T[]) new Object[internalArray.length];
                for (int i = 0; i < index; i++) {
                    tempArray[i] = internalArray[i];
                }
                tempArray[index] = element;
                for (int i = index + 1; i < size; i++) {
                    tempArray[i] = internalArray[i - 1];
                }
                internalArray = (T[]) tempArray;
            } else if (index == this.size && internalArray.length != this.size) {
                internalArray[index] = element;
            } else if (internalArray.length == this.size) {
                resize();
                tempArray = (T[]) new Object[internalArray.length + 1];
                for (int i = 0; i < index; i++) {
                    tempArray[i] = internalArray[i];
                }
                tempArray[index] = element;
                for (int i = index; i < internalArray.length - 1; i++) {
                    tempArray[i + 1] = internalArray[i];
                }
                internalArray = (T[]) tempArray;
            }
        } else {
            resize();
            internalArray[index] = element;
        }
        size++;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * @param index The index of the element to be removed.
     * @return Removed element.
     */
    public T remove(int index) {
        checkIndex(index);
        T removedElement = internalArray[index];
        T[] tempArray = internalArray;
        for (int i = index; i < size; i++) {
            tempArray[i] = internalArray[i - 1];
        }
        internalArray[index] = null;
        internalArray = tempArray;
        size--;
        return removedElement;
    }

    /**
     * Returns a string representation of the list.
     * Adjacent elements are separated by the characters ", " (comma and space).
     * @return The string representation of the elements, enclosed in square brackets ("[]").
     */
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("[");
        for (T element : internalArray) {
            strBuilder.append(element).append(", ");
        }
        strBuilder.setLength(strBuilder.length() - 2);
        strBuilder.append("]");
        return strBuilder.toString();
    }

    /**
     * Convert Custom ArrayList to Array with defined not NULL values.
     * @return The Array representation of the CustomArrayList.
     */
    public T[] toArray() {
        int n = this.size();
        T[] customListToArray = (T[]) new Object[n];
        for (int i = 0; i < n; i++) {
            customListToArray[i] = this.get(i);
        }
        return customListToArray;
    }

    private void resize() {
        int newSize = this.size() * 3 / 2 + 1;
        Object[] tempArray = (T[]) new Object[newSize];
        for (int i = 0; i < internalArray.length; i++) {
            tempArray[i] = internalArray[i];
        }
        internalArray = (T[]) tempArray;
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Value with Index " + index + " doesn't exist in Your CustomArrayList!");
        } else {
            return true;
        }
    }
}
