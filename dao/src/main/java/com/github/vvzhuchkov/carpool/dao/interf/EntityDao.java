package com.github.vvzhuchkov.carpool.dao.interf;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.model.Entity;

public interface EntityDao<Type extends Entity> {
    Integer create(Type entity) throws DAOException;

    Type read(Integer id) throws DAOException;

    void update(Type entity) throws DAOException;

    void delete(Integer id) throws DAOException;
}
