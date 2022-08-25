package com.github.vvzhuchkov.carpool.service.interf;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.model.AuthUser;

public interface RoleService {

    String getAuthUserRole(AuthUser authUser) throws DAOException;

}
