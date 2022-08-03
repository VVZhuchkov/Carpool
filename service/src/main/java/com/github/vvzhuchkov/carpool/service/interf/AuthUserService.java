package com.github.vvzhuchkov.carpool.service.interf;

import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.service.exception.ServiceException;

public interface AuthUserService {

    AuthUser login (String email, String password) throws ServiceException;

    Integer registration (AuthUser authUser) throws ServiceException;

}
