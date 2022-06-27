package com.github.vvzhuchkov.carpool.dao.implementation;

import com.github.vvzhuchkov.carpool.dao.interfaces.AuthUserDao;
import com.github.vvzhuchkov.carpool.model.AuthUser;

import java.sql.PreparedStatement;

public class DefaultAuthUserDao implements AuthUserDao {


    @Override
    public void create(AuthUser authUser) {
        try{
            PreparedStatement preparedStatement = initPoolData();


    }

    @Override
    public AuthUser read(Integer id) {
        return null;
    }

    @Override
    public void update(AuthUser authUser) {

    }

    @Override
    public void delete(Integer id) {

    }
}
