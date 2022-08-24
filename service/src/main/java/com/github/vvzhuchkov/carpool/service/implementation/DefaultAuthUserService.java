package com.github.vvzhuchkov.carpool.service.implementation;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.dao.factory.FactoryDao;
import com.github.vvzhuchkov.carpool.dao.interf.AuthUserDao;
import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.service.exception.ServiceException;
import com.github.vvzhuchkov.carpool.service.interf.AuthUserService;

import java.util.List;

public class DefaultAuthUserService implements AuthUserService {
    private static final AuthUserDao authUserDAO = FactoryDao.getInstance().getAuthUserDao();

    public AuthUser login(String email, String password) throws ServiceException {
        AuthUser authUser = null;
        try {
            authUser = authUserDAO.readByEmail(email);
        } catch (DAOException e) {
            throw new ServiceException("User with this email doesn't exist");
        }
        if (authUser != null && authUser.getPassword().equals(password)) {
            return authUser;
        }
        return null;
    }

    public List<AuthUser> getAllAuthUsers(){
        List<AuthUser> authUserList = authUserDAO.getAllAuthUsers();
        return authUserList;
    }
}
