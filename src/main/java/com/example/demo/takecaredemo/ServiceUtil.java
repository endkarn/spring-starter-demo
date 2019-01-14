package com.example.demo.takecaredemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
@ComponentScan(basePackages = "com.hdw.erp.common")
public class ServiceUtil {
	private static final Logger logger = LoggerFactory.getLogger(ServiceUtil.class);
	public String userAction;

	@Autowired
	private CommonRepository commonRepository;

	public String getUserAction() {
		return userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

	private Connection externalConn = null;

	public void setExternalConnection(Connection conn) {
		this.externalConn = conn;
	}

	public Connection getExternalConnection() {
		return this.externalConn;
	}

	public Connection openConnection(Connection conn) throws Exception {
		// get connection
		if (externalConn == null || externalConn.isClosed()) {
			conn = commonRepository.getConnection();
			conn.setAutoCommit(false);
//			logger.info(String.format("Open Connection : %s ", conn.toString()));
		} else {
			conn = this.getExternalConnection();
		}
		return conn;
	}

	public void commitConnection(Connection conn) throws Exception {
		if (this.getExternalConnection() == null) {
			logger.info("Commit Connection : " + conn);
			conn.commit();
		}
	}

	public void closeConnection(Connection conn) throws Exception {
		try {
			if ((conn != null) && !conn.isClosed() && this.getExternalConnection() == null) {

//				logger.info("Close Connection: " + conn + " completed.");
				conn.close();
				conn = null;
			} else {
//				logger.info("Try to Close Connection: " + conn );
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex);
		}
	}

	public ErpResponse setMessage(ErpResponse erpResponse, String action, String status) {
		if (action.equals(ApplicationConstant.INSERT))
			erpResponse.setMessage(ApplicationConstant.STATUS_MESSAGE_INSERT_SUCCESS);
		else if (action.equals(ApplicationConstant.UPDATE))
			erpResponse.setMessage(ApplicationConstant.STATUS_MESSAGE_UPDATE_SUCCESS);
		else if (action.equals(ApplicationConstant.DELETE))
			erpResponse.setMessage(ApplicationConstant.STATUS_MESSAGE_DELETE_SUCCESS);
		else if (action.equals(ApplicationConstant.FIND))
			erpResponse.setMessage(ApplicationConstant.STATUS_MESSAGE_FIND_SUCCESS);
		else if (action.equals(ApplicationConstant.NULL))
			erpResponse.setMessage(ApplicationConstant.STATUS_MESSAGE_FIND_NO_DATA);
		else
			erpResponse.setMessage(action);

		if (status.equals(ApplicationConstant.SUCCESS))
			erpResponse.setStatusCode(ApplicationConstant.STATUS_CODE_SUCCESS);
		else if (status.equals(ApplicationConstant.FAIL))
			erpResponse.setStatusCode(ApplicationConstant.STATUS_CODE_FAIL);
		else if (status.equals(ApplicationConstant.NULL))
			erpResponse.setStatusCode(ApplicationConstant.STATUS_CODE_OBJECT_NULL);
		else
			erpResponse.setStatusCode(ApplicationConstant.STATUS_CODE_FAIL);

		return erpResponse;
	}

	private Long startTime;

	public void startProcessTime() {
		this.startTime = System.currentTimeMillis();
	}

	public Long totalProcessTime() {
		return System.currentTimeMillis() - this.startTime;
	}
}
