package com.github.vvzhuchkov.carpool.dao.interf;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.model.AuthUser;

public interface AuthUserDao extends EntityDao<AuthUser> {
    AuthUser readByEmail (String email) throws DAOException;
}
