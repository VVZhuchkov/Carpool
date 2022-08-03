package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AuthUser extends Entity implements Serializable {
    private String email;
    private String password;
    private String status;
    private Set<Role> roleSet;

    public AuthUser(Integer id, String email, String password, String status) {
        super(id);
        this.email = email;
        this.password = password;
        this.status = status;
        this.roleSet = new HashSet<>();
    }

    public AuthUser(Integer id, String email, String password, String status, Set<Role> roleSet) {
        super(id);
        this.email = email;
        this.password = password;
        this.status = status;
        this.roleSet = roleSet;
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

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", roleSet=" + roleSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AuthUser authUser = (AuthUser) o;
        return email.equals(authUser.email) && password.equals(authUser.password) && status.equals(authUser.status) && roleSet.equals(authUser.roleSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password, status, roleSet);
    }
}

