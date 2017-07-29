package com.demo.stream;

import com.demo.collection.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("n1", 25));
        employees.add(new Employee("n3", 23));
        employees.add(new Employee("n2", 29));
        employees.add(new Employee("n4", 22));
        employees.add(new Employee("n5", 21));

        employees.stream().filter(e -> e.getAge() > 22).forEach(System.out::println);

        System.out.println(employees.stream().allMatch(e -> {
            return e.getAge() > 20;
        }));


        System.out.println(employees.stream().anyMatch(e -> {
            return e.getAge() == 29;
        }));

        /***
         * set age = 20 to all employees
         */
        employees.stream().map(e -> {
            e.setAge(20);
            return e;
        }).forEach(System.out::println);

        employees.stream().distinct().forEach(System.out::println);

        employees.stream().distinct().forEach(System.out::println);

        employees.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).forEach(System.out::println);

        System.out.println(employees.stream().findFirst().get());
        employees.stream().limit(2).forEach(System.out::println);

        employees.stream().collect(Collectors.toList()).forEach(System.out::println);
    }
}
