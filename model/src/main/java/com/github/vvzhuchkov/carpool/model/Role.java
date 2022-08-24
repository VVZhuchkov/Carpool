package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.util.Objects;

public class Role extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String roleAuthUser;


    public Role(Integer id, String roleAuthUser) {
        super(id);
        this.roleAuthUser = roleAuthUser;
    }

    public String getRoleAuthUser() {
        return roleAuthUser;
    }

    public void setRoleAuthUser(String roleAuthUser) {
        this.roleAuthUser = roleAuthUser;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleAuthUser=" + roleAuthUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return roleAuthUser == role.roleAuthUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleAuthUser);
    }
}
