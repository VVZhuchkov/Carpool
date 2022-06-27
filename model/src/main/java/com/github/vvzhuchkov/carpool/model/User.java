package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class User extends Entity implements Serializable {
    private String name;
    private String middleName;
    private String surname;
    private Gender gender;
    private Date birthDate;
    private String phone;
    private String address;

    public User(int id, String name, String surname, Gender gender, Date birthDate, String phone, String address) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    public User(int id, String name, String middleName, String surname, Gender gender, Date birthDate, String phone, String address) {
        super(id);
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && Objects.equals(middleName, user.middleName) && surname.equals(user.surname) && gender == user.gender && birthDate.equals(user.birthDate) && phone.equals(user.phone) && address.equals(user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, middleName, surname, gender, birthDate, phone, address);
    }
}
