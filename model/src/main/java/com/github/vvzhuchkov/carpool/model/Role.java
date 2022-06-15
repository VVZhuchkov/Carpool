package com.github.vvzhuchkov.carpool.model;

import java.util.Objects;

public class Role {
    private int id;
    private RoleAuthUser roleAuthUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleAuthUser getRole() {
        return roleAuthUser;
    }

    public void setRole(RoleAuthUser roleAuthUser) {
        this.roleAuthUser = roleAuthUser;
    }

    @Override
    public String toString() {
        return "RoleAuthUser {" +
                "idAuthUser=" + id +
                ", role=" + roleAuthUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role that = (Role) o;
        return id == that.id && roleAuthUser == that.roleAuthUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleAuthUser);
    }
}
