package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Driver extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String license;
    private Date issueDate;
    private Date endDate;

    public Driver(int id, String license, Date issueDate, Date endDate) {
        super(id);
        this.license = license;
        this.issueDate = issueDate;
        this.endDate = endDate;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Driver{" +
                ", license='" + license + '\'' +
                ", issueDate=" + issueDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return license.equals(driver.license) && issueDate.equals(driver.issueDate) && endDate.equals(driver.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(license, issueDate, endDate);
    }
}
