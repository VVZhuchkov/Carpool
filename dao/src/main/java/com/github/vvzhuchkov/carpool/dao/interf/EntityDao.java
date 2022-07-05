package com.github.vvzhuchkov.carpool.dao.interf;

import com.github.vvzhuchkov.carpool.dao.exception.DAOException;
import com.github.vvzhuchkov.carpool.model.Entity;

public interface EntityDao<Type extends Entity> {
    Integer create(Type entity) throws DAOException;

    Type read(Integer id);

    void update(Type entity);

    void delete(Integer id);
}
