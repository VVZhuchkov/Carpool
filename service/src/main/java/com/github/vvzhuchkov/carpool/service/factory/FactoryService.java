package com.github.vvzhuchkov.carpool.service.factory;

import com.github.vvzhuchkov.carpool.service.implementation.DefaultAuthUserService;
import com.github.vvzhuchkov.carpool.service.interf.AuthUserService;

public class FactoryService {
    private static volatile FactoryService instance;
    private final AuthUserService authUserService;
/*    private final CarDao carDao;
    private final DriverDao driverDao;
    private final MaintenanceDao maintenanceDao;
    private final OrderDao orderDao;
    private final RoleDao roleDao;
    private final UserDao userDao;*/

    public static FactoryService getInstance() {
        FactoryService localInstance = instance;
        if(localInstance == null){
            synchronized (FactoryService.class){
                localInstance = instance;
                if (localInstance == null){
                    instance = localInstance = new FactoryService();
                }
            }
        }
        return localInstance;
    }

    private FactoryService(){
        authUserService = new DefaultAuthUserService();
   /*     carDao = new DefaultCarDao();
        driverDao = new DefaultDriverDao();
        maintenanceDao = new DefaultMaintenanceDao();
        orderDao = new DefaultOrderDao();
        roleDao = new DefaultRoleDao();
        userDao = new DefaultUserDao();*/
    }

    public AuthUserService getAuthUserService(){
        return authUserService;
    }
}
