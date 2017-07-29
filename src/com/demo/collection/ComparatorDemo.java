package com.demo.collection;


import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("n1", 25));
        employees.add(new Employee("n3", 23));
        employees.add(new Employee("n2", 29));
        employees.add(new Employee("n4", 22));
        employees.add(new Employee("n5", 21));

        /***
         * Sort by Age
         */
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        /***
         * Sort by name
         */

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        /***
         * Using lambda expression
         */

        System.out.println("Sorted by lambda expression");

        Collections.sort(employees, (o1, o2) -> {
            return o1.getAge() - o2.getAge();
        });

        employees.stream().forEach(System.out::println);
    }
}
