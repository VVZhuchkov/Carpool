package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Role extends Entity implements Serializable {
    private RoleAuthUser roleAuthUser;
    private List<AuthUser> authUserList;


    public Role(Integer id, RoleAuthUser roleAuthUser) {
        super(id);
        this.roleAuthUser = roleAuthUser;
        List<AuthUser> authUserList = new ArrayList<>();
    }

    public Role(Integer id, RoleAuthUser roleAuthUser, List<AuthUser> authUserList) {
        super(id);
        this.roleAuthUser = roleAuthUser;
        this.authUserList = authUserList;
    }

    public RoleAuthUser getRoleAuthUser() {
        return roleAuthUser;
    }

    public void setRoleAuthUser(RoleAuthUser roleAuthUser) {
        this.roleAuthUser = roleAuthUser;
    }

    public List<AuthUser> getAuthUserList() {
        return authUserList;
    }

    public void setAuthUserList(List<AuthUser> authUserList) {
        this.authUserList = authUserList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleAuthUser=" + roleAuthUser +
                ", authUserList=" + authUserList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return roleAuthUser == role.roleAuthUser && authUserList.equals(role.authUserList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleAuthUser, authUserList);
    }
}
