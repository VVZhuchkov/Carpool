package com.github.vvzhuchkov.carpool.dao.connection;

import java.util.ResourceBundle;

/**
 * The {@code DBResourceManager} class uses singleton pattern to control the number of DBResourceBundle objects created.
 */
public class DBResourceManager {

    private final static DBResourceManager instance = new DBResourceManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("database");

    public static DBResourceManager getInstance() {
        return instance;
    }

    /**
     * Provides access to the db properties by the String key
     *
     * @param key a key name of db property
     * @return a string db key value
     */
    public String getValue(String key) {
        return bundle.getString(key);
    }
}