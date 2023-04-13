package com.other;

import java.util.Objects;

public class Person1 {

    private int id;
    public String name;

    @Override
    public boolean equals(Object o) {
        System.out.println("Person1调用equals();");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return id == person1.id && Objects.equals(name, person1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person1() {
    }
}
