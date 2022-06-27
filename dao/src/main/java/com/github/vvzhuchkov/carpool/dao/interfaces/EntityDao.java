package com.github.vvzhuchkov.carpool.dao.interfaces;

import com.github.vvzhuchkov.carpool.model.Entity;

public interface EntityDao<Type extends Entity> {
    void create(Type entity);

    Type read(Integer id);

    void update(Type entity);

    void delete(Integer id);
}
