package com.github.vvzhuchkov.carpool.dao.query;

public class SQLQuery {
    public static final String CREATE_AUTH_USER = "INSERT INTO auth_users (email, password, status) VALUES (?, ?, ?);";
    public static final String READ_AUTH_USER_BY_EMAIL = "SELECT * FROM auth_users WHERE email = (?)";
    public static final String READ_AUTH_USER_BY_ID = "SELECT * FROM auth_users WHERE id = (?)";
    public static final String READ_ALL_AUTH_USERS = "SELECT * FROM auth_users";
    public static final String UPDATE_AUTH_USER = "UPDATE auth_users SET password = (?), status = (?)";
    public static final String DELETE_AUTH_USER = "DELETE FROM auth_users WHERE author_id = (?)";
    public static final String CREATE_AUTH_USER_ROLE_LINK ="INSERT INTO auth_users_has_roles (auth_users_id, roles_id) VALUES (?,?)";
    public static final String READ_AUTH_USER_ROLE_BY_ID = "SELECT * FROM roles WHERE id = (?)";

    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String STATUS = "status";
    public static final String ROLES_ID = "roles_id";

}
