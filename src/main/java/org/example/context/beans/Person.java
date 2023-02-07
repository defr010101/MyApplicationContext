package org.example.context.beans;

import org.example.context.annotation.Component;
import org.example.context.annotation.Value;

@Component(name = "person")
public class Person {
    @Value(value = "Mikhail")
    private String name;
    @Value(value = "21")
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
