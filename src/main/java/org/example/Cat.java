package org.example;

import static java.lang.CharSequence.compare;

public class Cat implements Comparable<Cat> {
    private String name;
    private String color;
    private int age;

    public Cat() {
    }

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
               "name='" + name + '\'' +
               ", color='" + color + '\'' +
               ", age=" + age +
               '}';
    }

    @Override
    public int compareTo(Cat o) {
        int compare = compare(this.getName(), o.getName());
        return compare;
    }
}


