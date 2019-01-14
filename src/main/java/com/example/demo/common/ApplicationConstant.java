package com.example.demo.common;

public class ApplicationConstant {
	//	Business Data
	public static final String BUSINESS_EMAIL_SUBJECT = "Reply from Take Care Beauty and Salon";
	public static final String BUSINESS_SENDER_EMAIL = "support@takecare.com";
	public static final String BUSINESS_SENDER_NAME = "Take Care Beauty and Salon";

	public static final Boolean BUSSINESS_SENT_CONFIRM_PERSONNEL_EMAIL = Boolean.FALSE;

	public static final String TOKEN_HEADER = "Authorization";

//	// DataSource config
	public static final String DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mariadb://localhost:3306/erp?characterEncoding=utf-8";
	public static final String JDBC_USERNAME = "root";
	public static final String JDBC_PASSWORD = "root";

	// DataSource config
//	public static final String DRIVER_CLASS = "org.mariadb.jdbc.Driver";
//	public static final String JDBC_URL = "jdbc:mariadb://mariadb-service:3306/erp?characterEncoding=utf-8";
//	public static final String JDBC_USERNAME = "krystal";
//	public static final String JDBC_PASSWORD = "hdw.dev"; 
 
	// url web
	public static final String BASE_PATH = "http://103.253.72.142/#";

	public static final String FLAG_Y = "Y";
	public static final String FLAG_N = "N";
	public static final String SUCCESS_MESSAGE = "success";
	public static final String SUCCESS_CODE = "1";
	public static final String ERROR_MESSAGE = "error";
	public static final String ERROR_CODE = "0";

	// SYSTEM_CREATE can be User
	public static final Long SYSTEM_CREATE = 1L;
	public static final String EMPTY = "";

	// date format
	public static final String DATE_FORMAT1 = "yyyy-MM-dd HH:mm:ss";
	public static final String ERP_TIMEZONE = "Asia/Bangkok";
	public static final String ERP_LOCALE = "en";

	// Status ErpResponse
	public static final Long STATUS_CODE_SUCCESS = 200L;
	public static final Long STATUS_CODE_PERMISSION_DENIED = 403L;
	public static final Long STATUS_CODE_FAIL = 500L;
	public static final Long STATUS_CODE_OBJECT_NULL = 404L;
	public static final Long STATUS_CODE_DATA_FAIL = 11L;

	// Status Message
	public static final String INSERT = "INSERT";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public static final String FIND = "FIND";
	public static final String REPORT = "REPORT";

	public static final String SUCCESS = "SUCCESS";
	public static final String FAIL = "FAIL";
	public static final String NULL = "NULL";

	public static final String PERMISSION_DENIED = "permission denied";

	public static final String STATUS_MESSAGE_INSERT_SUCCESS = "Insert Data Success";
	public static final String STATUS_MESSAGE_UPDATE_SUCCESS = "Update Data Success";
	public static final String STATUS_MESSAGE_DELETE_SUCCESS = "Delete Data Success";
	public static final String STATUS_MESSAGE_FIND_SUCCESS = "Find Data Success";
	public static final String STATUS_MESSAGE_FIND_NO_DATA = "Data Not Found";

	public static final String STATUS_MESSAGE_INSERT_FAIL = "Insert Data Fail";
	public static final String STATUS_MESSAGE_UPDATE_FAIL = "Update Data Fail";
	public static final String STATUS_MESSAGE_DELETE_FAIL = "Delete Data Fail";
	public static final String STATUS_MESSAGE_FIND_FAIL = "Find Data Fail";
	public static final String STATUS_MESSAGE_CODE_EXCEPTION= "Code Exception";

	public static final String STATUS_MESSAGE_OBJECT_NULL = "Fail Object is null";

	public static final String STATUS_MESSAGE_MORE_ROW_FAIL = "Fail because More than 1 object";

	public static Long PERSON_ID = 0L;
	public static Long USER_ORG_ID = 0L;

	// USER TYPE
	public static final String USER_TYPE_EMPLOYEE = "employee";
	public static final String USER_TYPE_CUSTOMER = "customer";

	// PATH JASPER REPORT
	public static final String JASPER_REPORT_PATH = "jasper-report-file";

	// PREFIX
	public static final String PREFIX_MEMBER = "MEM-";
	public static final String PREFIX_CUSTOMER = "7SL";
	public static final String PREFIX_INVOICE = "INV-";
	public static final String PREFIX_EMPLOYEE = "EMP-";
	public static final String PREFIX_SERVICE = "SRV-";
	public static final String PREFIX_APPOINTMENT = "AQ-";
	public static final String PREFIX_WORKSHEET_DOC = "WKD-";
	public static final String PREFIX_WORKSHEET_ITEM = "TSK-";
	public static final String PREFIX_PACKAGE_SERVICE = "PCS-";
	public static final String PREFIX_PROMOTION = "PRM-";
	public static final String PREFIX_PRODUCT = "PRD-";
	public static final String PREFIX_RECEIVE_PRODUCT = "RECEIVE-";
	public static final String PREFIX_ADJUST_PRODUCT = "ADJUST-";
	public static final String PREFIX_ISSUE_PRODUCT = "ISSUE-";

	public static final int CODE_LENGTH = 5;

	public static final long STATUS_WORKSHEET_NEW_APPOINTMENT = 17L;
	public static final long STATUS_WORKSHEET_CONFIRMED = 18L;
	public static final long STATUS_WORKSHEET_PENDING = 19L;
	public static final long STATUS_WORKSHEET_ON_SERVICE = 20L;
	public static final long STATUS_WORKSHEET_COMPLETED = 21L;
	public static final long STATUS_WORKSHEET_CANCELLED = 22L;

}
