package com.github.vvzhuchkov.carpool.dao.implementation;

import com.github.vvzhuchkov.carpool.dao.connection.ConnectionPool;
import com.github.vvzhuchkov.carpool.dao.connection.ConnectionPoolException;
import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.dao.interf.RoleDao;
import com.github.vvzhuchkov.carpool.dao.query.SQLQuery;
import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultRoleDao implements RoleDao {

    @Override
    public String getAuthUserRole(AuthUser authUser) throws DAOException {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.READ_AUTH_USER_ROLE_BY_ID);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getString(SQLQuery.ROLES_ID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ConnectionPoolException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}