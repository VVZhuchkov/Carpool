package com.github.vvzhuchkov.carpool.dao.exception;

/**
 * The {@code DAOException} class represents a checked exception from {@link com.github.vvzhuchkov.carpool.dao}
 *
 * @see Exception
 */
public class DAOException extends Exception {
    private static final long serialVersionUID = 1L;

    public DAOException(String message, Exception e) {
        super(message, e);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException() {
        super();
    }
}



