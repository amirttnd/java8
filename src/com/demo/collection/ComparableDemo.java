package com.demo.collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("n1", 25));
        persons.add(new Person("n2", 23));
        persons.add(new Person("n3", 29));
        persons.add(new Person("n4", 22));
        persons.add(new Person("n5", 21));
        Collections.sort(persons);
        Iterator<Person> iterator=persons.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
