package com.mockup.register.sdk.util;

import java.sql.Date;

public class DateUtil {

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }
    public static java.util.Date getNow() {
        return new java.util.Date();
    }

}
