package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.util.Objects;

public class AuthUser extends Entity implements Serializable {
    private String email;
    private String password;
    private String status;
    private Role role;

    public AuthUser(Integer id, String email, String password, String status) {
        super(id);
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public AuthUser(Integer id, String email, String password, String status, Role role) {
        super(id);
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", role" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AuthUser authUser = (AuthUser) o;
        return email.equals(authUser.email) && password.equals(authUser.password) && status.equals(authUser.status) && role.equals(authUser.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password, status, role);
    }
}

