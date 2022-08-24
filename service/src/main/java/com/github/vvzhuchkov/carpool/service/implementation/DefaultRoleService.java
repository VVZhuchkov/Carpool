package com.github.vvzhuchkov.carpool.service.implementation;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.dao.factory.FactoryDao;
import com.github.vvzhuchkov.carpool.dao.interf.RoleDao;
import com.github.vvzhuchkov.carpool.model.AuthUser;
import com.github.vvzhuchkov.carpool.service.factory.FactoryService;
import com.github.vvzhuchkov.carpool.service.interf.RoleService;

public class DefaultRoleService implements RoleService {
    private static final RoleDao roleDao = FactoryDao.getInstance().getRoleDao();

    public String getAuthUserRole(AuthUser authUser) throws DAOException {
        String role = roleDao.getAuthUserRole(authUser.getIdRoleAuthUser());
        return role;
    }
}
