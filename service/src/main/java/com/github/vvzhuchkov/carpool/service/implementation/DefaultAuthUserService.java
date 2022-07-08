package com.github.vvzhuchkov.carpool.service.implementation;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.dao.factory.FactoryDao;
import com.github.vvzhuchkov.carpool.dao.interf.AuthUserDao;
import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.service.exception.ServiceException;
import com.github.vvzhuchkov.carpool.service.interf.AuthUserService;

public class DefaultAuthUserService implements AuthUserService {
    private static final AuthUserDao authUserDAO = FactoryDao.getInstance().getAuthUserDao();

    public AuthUser login(String email, String password) throws ServiceException {
        try {
            AuthUser authUser = authUserDAO.readByEmail(email);
            if (authUser.getPassword().equals(password)) {
                return authUser;
            }
        } catch (DAOException e) {
            throw new ServiceException("User with this email doesn't exist");
        }
        return null;
    }

    public boolean registration(AuthUser authUser) throws ServiceException {
        boolean isCreated;
        try {
          isCreated = authUserDAO.create(authUser);
        } catch (DAOException e) {
            throw new ServiceException("Database error. Impossible to create user with these credentials");
        }
        return isCreated;
    }
}
