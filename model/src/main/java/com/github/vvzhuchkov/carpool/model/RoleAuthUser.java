package com.github.vvzhuchkov.carpool.model;

import java.util.HashMap;
import java.util.Map;

public class RoleAuthUser {
    private static final String ADMINISTRATOR = "administrator";
    private static final String DISPATCHER = "dispatcher";
    private static final String DRIVER = "driver";

    private static Map<Integer, String> roleAuthUserMap = new HashMap();

    static {
        roleAuthUserMap.put(1, ADMINISTRATOR);
        roleAuthUserMap.put(2, DISPATCHER);
        roleAuthUserMap.put(3, DRIVER);
    }

    public String getRoleAuthUser (Integer idRoleAuthUser){
        return roleAuthUserMap.get(idRoleAuthUser);
    }
}
