package com.mockup.register.sdk.util;

import java.util.UUID;

public class StringUtil {
    public static String getUuid() {
        return UUID.randomUUID().toString();
    }
    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty() || "NULL".equalsIgnoreCase(s);
    }
}
