package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;

public class AuthUser implements Serializable {
    private int id;
    private String email;
    private String password;
    private boolean status;

    public AuthUser(int id, String email, String password, boolean status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" + " email = " + email + ", password = " + password + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        AuthUser authUser = (AuthUser) o;
        return email == authUser.email;
    }

    @Override
    public int hashCode() {
        return 31 * email.hashCode();
    }
}
