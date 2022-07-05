package com.github.vvzhuchkov.carpool.dao.query;

public class SQLQuery {
    public static final String CREATE_AUTH_USER = "INSERT INTO auth_users (email, password, status) VALUES (?, ?, ?);";
    public static final String READ_AUTH_USER_BY_EMAIL = "SELECT * FROM auth_users WHERE email = (?)";
    public static final String READ_AUTH_USER_BY_ID = "SELECT * FROM auth_users WHERE id = (?)";
    public static final String UPDATE_AUTH_USER = "UPDATE auth_users SET password = (?), status = (?)";
    public static final String DELETE_AUTH_USER = "DELETE FROM auth_users WHERE author_id = (?)";

    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String STATUS = "status";

}
