package com.github.vvzhuchkov.carpool.dao.implementation;

import com.github.vvzhuchkov.carpool.dao.connection.ConnectionPool;
import com.github.vvzhuchkov.carpool.dao.connection.ConnectionPoolException;
import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.dao.interf.AuthUserDao;
import com.github.vvzhuchkov.carpool.dao.query.SQLQuery;
import com.github.vvzhuchkov.carpool.model.AuthUser;

import java.sql.*;

public class DefaultAuthUserDao implements AuthUserDao {

    @Override
    public synchronized Integer authUserCreate(AuthUser authUser) throws DAOException{
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.CREATE_AUTH_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, authUser.getEmail());
            preparedStatement.setString(2, authUser.getPassword());
            preparedStatement.setString(3, authUser.getStatus());
            preparedStatement.execute();
            preparedStatement.executeUpdate();
            ResultSet generatedKey = preparedStatement.getGeneratedKeys();
            generatedKey.next();
            return generatedKey.getInt(1);
        } catch (SQLException e) {
            throw new DAOException("Check SQL query", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection hasn't been taken", e);
        }
    }

    public AuthUser read(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(SQLQuery.READ_AUTH_USER_BY_ID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AuthUser(resultSet.getInt(SQLQuery.ID), resultSet.getString(SQLQuery.EMAIL), resultSet.getString(SQLQuery.PASSWORD), resultSet.getString(SQLQuery.STATUS));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AuthUser readByEmail(String email) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.READ_AUTH_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AuthUser(resultSet.getInt(SQLQuery.ID), resultSet.getString(SQLQuery.EMAIL),
                        resultSet.getString(SQLQuery.PASSWORD), resultSet.getString(SQLQuery.STATUS));
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException("Incorrect login or email");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(AuthUser authUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(SQLQuery.UPDATE_AUTH_USER);
            preparedStatement.setString(1, authUser.getPassword());
            preparedStatement.setString(2, authUser.getStatus());
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(SQLQuery.DELETE_AUTH_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}