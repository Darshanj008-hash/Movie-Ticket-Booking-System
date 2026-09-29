package com.reva.movie.model;

public abstract class Person {
    private String name;
    private String phone;
    protected static int personCount = 0;

    public Person() {
        this("Unknown", "Not Provided");
    }

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
        personCount++;
    }

    public abstract String getRole();

    public final void printIdentity() {
        // Final method prevents subclasses from changing the standard identity display.
        System.out.println(name + " - " + getRole());
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public static int getPersonCount() { return personCount; }
}
