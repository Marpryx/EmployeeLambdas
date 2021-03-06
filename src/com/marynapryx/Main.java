package com.marynapryx;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Employee elly = new Employee("Elly Mirkat", "manager", 30, 4);
        Employee ellyS = new Employee("Elly Mirkat", "manager", 23, 1);
        Employee jack = new Employee("Jack Bim", "SEO", 45, 12);
        Employee linda = new Employee("Linda Golovna", "software developer", 47, 18);
        Employee sergio = new Employee("Sergio Govanny", "QA analist", 33, 4);
        Employee dzen = new Employee("Dzen Ioanna", "manager", 45, 16);
        Employee jilly = new Employee("Jilly Jackson", "devOps", 33, 1);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(elly);
        employeeList.add(ellyS);
        employeeList.add(jack);
        employeeList.add(linda);
        employeeList.add(sergio);
        employeeList.add(dzen);
        employeeList.add(jilly);



        //Step 1 - Regular way used in Java7: To sort the elements of the List in specific order

//        Collections.sort(employeeList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        //Step 2 - Java8: To sort the elements of the List in specific order by using Lambda expression
//        Collections.sort(employeeList, (Employee employee1, Employee employee2) ->
//                employee1.getName().compareTo(employee2.getName()));


        //Step 3 - Java8: To sort the elements of the List in specific order by using method reference.
        //Method references let us reuse a method as a lambda expression
        Collections.sort(employeeList, Comparator.comparing(Employee::getName));



        //Step 4 - For each loop to loop through the list
//        for(Employee employee : employeeList){
//            System.out.println(employee.getName());
//        }

        //Step 4 - For each loop modified to .forEach + Lambda
        employeeList.forEach((v) -> System.out.println(v.getName()));

        //Convert collection to Stream - A stream represents a sequence of elements and supports different kind of
        // operations to perform computations upon those elements
        // There are some of the available operations in the code below

        System.out.println("============Stream with Filter==========");

         employeeList.stream()
                     .filter(s -> s.getName().startsWith("J")) //Filter to output only the name starts with "J"
                     .map(Employee::getName)
                     .sorted() //sorted in case if it will give more than 1 line of output
                     .forEach(System.out::println);


        System.out.println("=========Count the elements of the stream ===========");

        System.out.println(employeeList.stream()
                                       .count());

        System.out.println("=========Print the first element of the Stream if it exists ===========");

        employeeList.stream()
                .findFirst()
                .map(Employee::getPosition)
                .ifPresent(System.out::println);

        System.out.println("==========Print the employee names group by and + age");
        System.out.println(employeeList.stream()
                    .collect(Collectors.groupingBy
                            (Employee::getName, Collectors.summingInt(Employee::getAge))));

        System.out.println("==========Print the employee names group by and count if there are similar names");
        System.out.println(employeeList.stream()
                .collect(Collectors.groupingBy
                        (Employee::getName,Collectors.counting())));
    }



}

