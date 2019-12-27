package com.jn.util;

import java.util.UUID;

public class MyUUID {
    public static String getUUID() {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;

    }

}
