package com.github.vvzhuchkov.carpool.dao.factory;

import com.github.vvzhuchkov.carpool.dao.connection.ConnectionPool;
import com.github.vvzhuchkov.carpool.dao.implementation.*;
import com.github.vvzhuchkov.carpool.dao.interfaces.*;

public class FactoryDao {
    private static volatile FactoryDao instance;
    private final AuthUserDao authUserDao;
/*    private final CarDao carDao;
    private final DriverDao driverDao;
    private final MaintenanceDao maintenanceDao;
    private final OrderDao orderDao;
    private final RoleDao roleDao;
    private final UserDao userDao;*/

    public static FactoryDao getInstance() {
        FactoryDao localInstance = instance;
        if(localInstance == null){
            synchronized (ConnectionPool.class){
                localInstance = instance;
                if (localInstance == null){
                    instance = localInstance = new FactoryDao();
                }
            }
        }
        return localInstance;
    }

    private FactoryDao(){
        authUserDao = new DefaultAuthUserDao();
   /*     carDao = new DefaultCarDao();
        driverDao = new DefaultDriverDao();
        maintenanceDao = new DefaultMaintenanceDao();
        orderDao = new DefaultOrderDao();
        roleDao = new DefaultRoleDao();
        userDao = new DefaultUserDao();*/
    }
}
