package com.marynapryx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee elly = new Employee("Elly Mirkat", "manager", 30, 4);
        Employee jack = new Employee("Jack Bim", "SEO", 45, 12);
        Employee linda = new Employee("Linda Golovna", "software developer", 47, 18);
        Employee sergio = new Employee("Sergio Govanny", "QA analist", 33, 4);
        Employee dzen = new Employee("Dzen Ioanna", "manager", 45, 16);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(elly);
        employeeList.add(jack);
        employeeList.add(linda);
        employeeList.add(sergio);
        employeeList.add(dzen);


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


        //Step 3 - Java8: To sort the elements of the List in specific order by using method reference
        Collections.sort(employeeList, Comparator.comparing(Employee::getName));



        //Step 4 - For each loop to loop through the list
//        for(Employee employee : employeeList){
//            System.out.println(employee.getName());
//        }

        //Step 4 - For each loop modified to .forEach + Lambda
        employeeList.forEach((v) -> System.out.println(v.getName()));

    }

}

/**
 * Simple Employee class that is a blueprint for creating an Employee objects
 */
class Employee{
    private String name;
    private String position;
    private int age;
    private int experience;

    public Employee(String name, String position, int age, int experience) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}