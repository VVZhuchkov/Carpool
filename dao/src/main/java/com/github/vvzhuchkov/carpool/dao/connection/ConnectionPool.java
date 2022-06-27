package com.github.vvzhuchkov.carpool.dao.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPool {
    private BlockingQueue<Connection> givenConnection;
    private BlockingQueue<Connection> freeConnection;
    private String driver;
    private String url;
    private String user;
    private String password;
    private int poolSize;

    private ConnectionPool() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource");
        this.driver = resourceBundle.getString(DatabaseProperties.DRIVER);
        this.url = resourceBundle.getString(DatabaseProperties.URL);
        this.user = resourceBundle.getString(DatabaseProperties.USER);
        this.password = resourceBundle.getString(DatabaseProperties.PASSWORD);
        try {
            this.poolSize = Integer.parseInt(resourceBundle.getString(DatabaseProperties.POOLSIZE));
        } catch (NumberFormatException e) {
            poolSize = 5;
        }
    }

    public void createPoolData() throws PoolException {
        try {
            Class.forName(driver);
            givenConnection = new ArrayBlockingQueue<>(poolSize);
            freeConnection = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
//OverridedConnection?
                freeConnection.add(connection);
            }
        } catch (SQLException e) {
            throw new PoolException("SQL exception in initPoolData", e);
        } catch (ClassNotFoundException e) {
            throw new PoolException("db.driver class wasn't found", e);
        }
    }


}
