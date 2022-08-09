package com.github.vvzhuchkov.carpool.dao.connection;

/**
 * The {@code ConnectionPoolException} class represents a checked exception from
 * {@link com.github.vvzhuchkov.carpool.dao.connection}
 * @see Exception
 */
public class ConnectionPoolException extends Exception {

    public ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }
}
