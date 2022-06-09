package com.github.vvzhuchkov.carpool.model;

public class AuthUser {
    private String email;
    private String password;
    private Role role;

    public AuthUser(String email, String password, Role role) {
        this.email = email;
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthUser {" + "email = " + email + ", password = " + password + ", role = " + role + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        AuthUser authUser = (AuthUser) obj;
        return email == authUser.email;
    }

    @Override
    public int hashCode() {
        return 31 * email.hashCode();
    }
}
