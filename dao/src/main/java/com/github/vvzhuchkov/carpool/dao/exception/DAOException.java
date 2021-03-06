package com.github.vvzhuchkov.carpool.dao.exception;

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