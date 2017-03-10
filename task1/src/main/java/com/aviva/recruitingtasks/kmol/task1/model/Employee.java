package com.aviva.recruitingtasks.kmol.task1.model;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee)o;

        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode(){
        int result = 1;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
