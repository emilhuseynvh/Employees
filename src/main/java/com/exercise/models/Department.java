package com.exercise.models;

public class Department {
    private int id;
    private String name;
    private String manager;

    public Department(int id, String name, String manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    public Department(String name, String manager) {
        this.name = name;
        this.manager = manager;
    }

    public Department(Integer id, String manager) {
        this.id = id;
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty");
        }
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        if (manager == null || manager.trim().isEmpty()) {
            throw new IllegalArgumentException("Manager name cannot be null or empty");
        }
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", manager=" + manager + "]";
    }
}
