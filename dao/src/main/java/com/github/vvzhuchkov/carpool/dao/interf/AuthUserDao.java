package com.github.vvzhuchkov.carpool.dao.interf;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.model.AuthUser;

public interface AuthUserDao {

    Integer authUserCreate(AuthUser authUser) throws DAOException;

    AuthUser readByEmail (String email) throws DAOException;
}
