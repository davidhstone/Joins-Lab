package com.example.davidstone.myjoinsapp;

/**
 * Created by davidstone on 7/17/16.
 */
public class Employees {

    private String emplSSN;
    private String firstName;
    private String lastName;
    private String yob;
    private String city;

    public Employees (String emplSSN, String firstName, String lastName,
                    String yob, String city) {
        this.emplSSN = emplSSN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yob = yob;
        this.city = city;
    }

    public String getEmplSSN() {
        return emplSSN;
    }

    public void setEmplSSN(String emplSSN) {
        this.emplSSN = emplSSN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getYob() {
        return yob;
    }

    public void setYob (String yob) {
        this.yob = yob;
    }

    public String getCity() {
        return city;
    }

    public void setCity (String city) {
        this.city = city;
    }
}
