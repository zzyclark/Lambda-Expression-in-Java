package com.superclark.model;


/**
 * @Author clark
 * @Date 09-Nov-2015
 */
public class User {
    private String name;
    private String address;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ");
        builder.append(this.name);
        builder.append("\n Age: ");
        builder.append(this.age);
        builder.append("\n Address: ");
        builder.append(this.address);
        return builder.toString();
    }

    public User(String name, String address, Integer age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public void printUser() {
        System.out.println(this.toString());
    }
}
