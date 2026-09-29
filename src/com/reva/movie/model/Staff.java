package com.reva.movie.model;

public class Staff extends Person {
    private final String employeeId;

    public Staff(String name, String phone, String employeeId) {
        super(name, phone);
        this.employeeId = employeeId;
    }

    @Override
    public String getRole() {
        return "Staff";
    }

    public String getEmployeeId() { return employeeId; }
}
