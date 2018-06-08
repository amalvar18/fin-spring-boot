package com.finomyr.finomyrapp.utils;

/**
 * Constant values for UI manipulation
 * 
 * @author amalvar
 * @since 0.1.1
 * @version 0.3
 */
public class FinomyrUIConstants {

    /* Error Page Mappings */
    public static final String DEFAULT_ERROR_VIEW = "pages/errorpage";
    public static final String DB_ERROR_VIEW = "pages/error/dberror";

    /* Exception Error Codes */
    public static final String HIBERNATE_EXC_ERR_CODE = "02HIB";
    public static final String DATA_EXC_ERR_CODE = "03DAE";
    public static final String JDBC_GENERIC_ERR_CODE = "10JDBC";
    public static final String SQL_GRAMMAR_ERR_CODE = "11SQLG";
    public static final String CONSTRAINT_VIOLATION_ERR_CODE = "12CNSV";

    /* Exception Error Messages */
    public static final String SQL_GRAMMAR_ERR_MSG = "There was a problem with the SQL";
    public static final String JDBC_GENERIC_ERR_MSG = "A Database Error Occurred";

    public static final String CSS_ERROR_CLASS = "danger";
    public static final String CSS_SUCCESS_CLASS = "success";
    public static final String CSS_WARNING_CLASS = "warning";

    public static final String LOGOUT_SUCCESS_URL = "/login?logout=true";
    public static final String LOGIN_URL = "/login";

}
