package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.util.Objects;

public class AuthUser extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String email;
    private String password;
    private String status;
    private Integer idRoleAuthUser;

    public AuthUser(String email, String password, String status, Integer idRoleAuthUser) {
        this.email = email;
        this.password = password;
        this.status = status;
        this.idRoleAuthUser = idRoleAuthUser;
    }

    public AuthUser(Integer id, String email, String password, String status, Integer idRoleAuthUser) {
        super(id);
        this.email = email;
        this.password = password;
        this.status = status;
        this.idRoleAuthUser = idRoleAuthUser;
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

    public Integer getIdRoleAuthUser() {
        return idRoleAuthUser;
    }

    public void setIdRoleAuthUser(Integer idRoleAuthUser) {
        this.idRoleAuthUser = idRoleAuthUser;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", idRoleAuthUser=" + idRoleAuthUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AuthUser authUser = (AuthUser) o;
        return Objects.equals(email, authUser.email) && Objects.equals(password, authUser.password) && Objects.equals(status, authUser.status) && Objects.equals(idRoleAuthUser, authUser.idRoleAuthUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password, status, idRoleAuthUser);
    }
}

