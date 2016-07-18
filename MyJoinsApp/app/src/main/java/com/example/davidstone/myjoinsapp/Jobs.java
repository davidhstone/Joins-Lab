package com.example.davidstone.myjoinsapp;

/**
 * Created by davidstone on 7/17/16.
 */
public class Jobs {

    private String jobsSSN;
    private String company;
    private String salary;
    private String experience;

    public Jobs(String jobsSSN, String company, String salary, String experience) {

        this.jobsSSN = jobsSSN;
        this.company = company;
        this.salary = salary;
        this.experience = experience;
    }

    public String getJobsSSN() {
        return jobsSSN;
    }

    public void setJobsSSN(String jobsSSN) {
        this.jobsSSN = jobsSSN;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany (String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary (String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience (String experience) {
        this.experience = experience;
    }
}
