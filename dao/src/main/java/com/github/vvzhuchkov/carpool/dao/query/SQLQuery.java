package com.github.vvzhuchkov.carpool.dao.query;

public class SQLQuery {
    public static final String CREATE_USER = "INSERT INTO auth_users (email, password, status) VALUES (?, ?, ?);";
    public static final String READ_USER_BY_EMAIL = "SELECT * FROM auth_users WHERE email = (?)";
}
