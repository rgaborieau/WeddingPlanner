package com.atoukprod.weddingplanner.model;

public class Guest {

    private final String firstname;
    private final String lastname;
    private boolean present = false;

    public Guest(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

}
