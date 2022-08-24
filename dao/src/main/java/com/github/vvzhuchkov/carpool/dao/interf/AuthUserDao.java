package com.github.vvzhuchkov.carpool.dao.interf;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.model.AuthUser;

import java.util.List;

public interface AuthUserDao {

    AuthUser readAuthUserById(Integer id);

    Integer authUserCreate(AuthUser authUser) throws DAOException;

    AuthUser readByEmail(String email) throws DAOException;

    List<AuthUser> getAllAuthUsers();

    Integer updateAuthUser (AuthUser authUser);
}
