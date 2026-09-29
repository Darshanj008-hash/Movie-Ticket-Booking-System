package com.reva.movie.model;

public class Customer extends Person {
    private String email;

    public Customer() {
        this("Guest", "Not Provided", "guest@example.com");
    }

    public Customer(String name, String phone, String email) {
        super(name, phone);
        this.email = email;
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("Customer{name='%s', phone='%s', email='%s'}", getName(), getPhone(), email);
    }
}
