package com.employee;

/**
 * Created by rajan on 13/8/14.
 */
public class EmployeePOJO {
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    private String id;
    private String name;
    private String role;
}
