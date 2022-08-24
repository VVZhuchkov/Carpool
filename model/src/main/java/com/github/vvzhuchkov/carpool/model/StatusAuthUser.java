package com.github.vvzhuchkov.carpool.model;

import java.util.HashMap;
import java.util.Map;

public class StatusAuthUser {
    private static final String ACTIVE = "active";
    private static final String INACTIVE = "inactive";

    private static Map<Integer, String> statusAuthUserMap = new HashMap();

    static {
        statusAuthUserMap.put(1, ACTIVE);
        statusAuthUserMap.put(2, INACTIVE);
    }

    public static String getRoleAuthUser(Integer idRoleAuthUser) {
        return statusAuthUserMap.get(idRoleAuthUser);
    }
}
