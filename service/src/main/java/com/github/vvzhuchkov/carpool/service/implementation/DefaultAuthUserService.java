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
            return authUser;
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public AuthUser registration(String email, String password, String status) {
        return null;
    }
}
