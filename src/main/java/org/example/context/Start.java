package org.example.context;

import org.example.context.beans.Person;

public class Start {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ApplicationContext context = new AnnotationApplicationContext(Person.class);

        Person person = (Person) context.getBean("person");

        System.out.println(person.toString());
    }
}
