package com.marynapryx;

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