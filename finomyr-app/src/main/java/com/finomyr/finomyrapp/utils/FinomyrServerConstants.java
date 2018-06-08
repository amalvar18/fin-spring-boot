package com.finomyr.finomyrapp.utils;

import java.sql.Timestamp;

/**
 * Constant values for server side use
 * 
 * @author amalvar
 * @since 0.1.1
 * @version 0.2
 */
public class FinomyrServerConstants {

    public static final long SIM_DELAY_DURATION = 5000L;

    public static final String LOG_DATE_FORMAT = "dd MMM YYYY HH:mm:ss";

    public static final Timestamp CURRENT_TIMESTAMP = new Timestamp(System.currentTimeMillis());

    public static final Integer DEFAULT_USERID = 1;
    public static final String DEFAULT_USERNAME = "DummyUser";

    public static final String USER_ROLE = "USER";
    public static final String ADMIN_ROLE = "ADMIN";
}
