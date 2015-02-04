package com.ib;


/**
 * Constant values used throughout the application.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public final class Constants {

    private Constants() {
        // hide me
    }
    //~ Static fields/initializers =============================================

    /**
     * Assets Version constant
     */
    public static final String ASSETS_VERSION = "assetsVersion";
    /**
     * The name of the ResourceBundle used in this application
     */
    public static final String BUNDLE_KEY = "ApplicationResources";

    /**
     * File separator from System properties
     */
    public static final String FILE_SEP = System.getProperty("file.separator");

    /**
     * User home from System properties
     */
    public static final String USER_HOME = System.getProperty("user.home") + FILE_SEP;

    /**
     * The name of the configuration hashmap stored in application scope.
     */
    public static final String CONFIG = "appConfig";

    /**
     * Session scope attribute that holds the locale set by the user. By setting this key
     * to the same one that Struts uses, we get synchronization in Struts w/o having
     * to do extra work or have two session-level variables.
     */
    public static final String PREFERRED_LOCALE_KEY = "org.apache.struts2.action.LOCALE";

    /**
     * The request scope attribute under which an editable user form is stored
     */
    public static final String USER_KEY = "userForm";

    /**
     * The request scope attribute that holds the user list
     */
    public static final String USER_LIST = "userList";

    /**
     * The request scope attribute for indicating a newly-registered user
     */
    public static final String REGISTERED = "registered";

    /**
     * The name of the Administrator role, as specified in web.xml
     */
    public static final String ADMIN_ROLE = "ROLE_ADMIN";

    /**
     * The name of the User role, as specified in web.xml
     */
    public static final String USER_ROLE = "ROLE_USER";

    /**
     * The name of the user's role list, a request-scoped attribute
     * when adding/editing a user.
     */
    public static final String USER_ROLES = "userRoles";

    /**
     * The name of the available roles list, a request-scoped attribute
     * when adding/editing a user.
     */
    public static final String AVAILABLE_ROLES = "availableRoles";

    /**
     * The name of the CSS Theme setting.
     * @deprecated No longer used to set themes.
     */
    public static final String CSS_THEME = "csstheme";

    public static final String STATUS_SUKSES = "SUKSES";

    public static final String SAME_BANK = "sameBank";
    public static final String OTHER_BANK = "otherBank";

    public static final Integer SIMULATOR_DATACOUNT = 7;
    public static final String TYPE_BALANCE_INQUIRY = "BALANCE_INQUIRY";
    public static final String TYPE_ACCOUNT_STATEMENT = "ACCOUNT_STATEMENT";
    public static final String TYPE_ACCOUNT_STATEMENT_SUMMARY = "ACCOUNT_STATEMENT_SUMMARY";
    public static final String TYPE_TRANSFER_REGISTER_SAME_BANK = "TRANSFER_REGISTER_SAME_BANK";
    public static final String TYPE_TRANSFER_REGISTER_OTHER_BANK = "TRANSFER_REGISTER_OTHER_BANK";
    public static final String TYPE_TRANSFER_SAME_BANK = "TRANSFER_SAME_BANK";
    public static final String TYPE_TRANSFER_OTHER_BANK = "TRANSFER_OTHER_BANK";

    public static final String TYPE_PURCHASE_VOUCHER_PHONE = "PURCHASE_VOUCHER_PHONE";
    public static final String TYPE_PURCHASE_VOUCHER_ELECTRICITY = "PURCHASE_VOUCHER_ELECTRICITY";

    public static final String TYPE_PAYMENT_POSTPAID = "PAYMENT_POSTPAID";
    public static final String TYPE_PAYMENT_ELECTRICITY = "PAYMENT_ELECTRICITY";
    public static final String TYPE_PAYMENT_TV = "PAYMENT_TV";
}
