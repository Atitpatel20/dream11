package com.dream11.dream11;

public class Employee {
    private String name;
    private String email;

    private long mobile;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getMobile() {
        return mobile;
    }

    public Employee(String name, String email, long mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }


}
