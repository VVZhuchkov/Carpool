package com.github.vvzhuchkov.carpool.dao.connection;

public class PoolException extends Exception {

    public PoolException(String message, Exception e) {
        super(message, e);
    }
}
