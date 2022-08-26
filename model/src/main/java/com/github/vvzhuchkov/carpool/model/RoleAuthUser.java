package com.github.vvzhuchkov.carpool.model;

import java.util.HashMap;
import java.util.Map;

public class RoleAuthUser {
    private static final String ADMINISTRATOR = "Administrator";
    private static final String DISPATCHER = "Dispatcher";
    private static final String DRIVER = "Driver";

    private static Map<String, Integer> roleAuthUserMap = new HashMap();

    static {
        roleAuthUserMap.put(ADMINISTRATOR, 1);
        roleAuthUserMap.put(DISPATCHER, 2);
        roleAuthUserMap.put(DRIVER, 3);
    }

    public Integer getRoleAuthUser (String role){
        return roleAuthUserMap.get(role);
    }
}
