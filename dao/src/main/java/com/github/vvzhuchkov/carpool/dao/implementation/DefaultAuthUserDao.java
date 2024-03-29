package com.github.vvzhuchkov.carpool.dao.implementation;

import com.github.vvzhuchkov.carpool.dao.connection.ConnectionPool;
import com.github.vvzhuchkov.carpool.dao.connection.ConnectionPoolException;
import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.dao.interf.AuthUserDao;
import com.github.vvzhuchkov.carpool.dao.query.SQLQuery;
import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.model.StatusAuthUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultAuthUserDao implements AuthUserDao {

    @Override
    public synchronized Integer authUserCreate(AuthUser authUser) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.CREATE_AUTH_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, authUser.getEmail());
            preparedStatement.setString(2, authUser.getPassword());
            preparedStatement.setString(3, authUser.getStatus());
            preparedStatement.setInt(4, authUser.getIdRoleAuthUser());
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

    @Override
    public AuthUser readAuthUserById(Integer id) {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.READ_AUTH_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AuthUser(resultSet.getInt(SQLQuery.ID), resultSet.getString(SQLQuery.EMAIL),
                        resultSet.getString(SQLQuery.PASSWORD), resultSet.getString(SQLQuery.STATUS), resultSet.getInt(SQLQuery.ROLES_ID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AuthUser> getAllAuthUsers() {
        List<AuthUser> authUserArrayList = null;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.READ_ALL_AUTH_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            authUserArrayList = new ArrayList<>();
            while (resultSet.next()) {
                final AuthUser authUser = new AuthUser(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("status"),
                        resultSet.getInt("roles_id"));
                authUserArrayList.add(authUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
        return authUserArrayList;
    }

    @Override
    public AuthUser readByEmail(String email) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.READ_AUTH_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AuthUser(resultSet.getInt(SQLQuery.ID), resultSet.getString(SQLQuery.EMAIL),
                        resultSet.getString(SQLQuery.PASSWORD), resultSet.getString(SQLQuery.STATUS), resultSet.getInt(SQLQuery.ROLES_ID));
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection hasn't been taken", e);
        } catch (SQLException e) {
            throw new DAOException("Check SQL query", e);
        }
        return null;
    }

    @Override
    public Integer updateAuthUser(AuthUser authUser) {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.UPDATE_AUTH_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, authUser.getPassword());
            preparedStatement.setString(2, authUser.getStatus());
            preparedStatement.setInt(3, authUser.getIdRoleAuthUser());
            preparedStatement.executeUpdate();
            ResultSet generatedKey = preparedStatement.getGeneratedKeys();
            generatedKey.next();
            return generatedKey.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ConnectionPoolException e) {
            throw new RuntimeException(e);
        }
    }

    //Set status to "inactive"
    public synchronized Integer deleteAuthUser(Integer id) {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.DELETE_AUTH_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, StatusAuthUser.getRoleAuthUser(2));
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            ResultSet generatedKey = preparedStatement.getGeneratedKeys();
            generatedKey.next();
            return generatedKey.getInt(1);
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}