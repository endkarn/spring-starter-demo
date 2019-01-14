package com.example.demo.takecaredemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HandleMessage {
	public ErpResponse processSuccess(ErpResponse erpResponse) {
		erpResponse.setMessage(ApplicationConstant.SUCCESS_MESSAGE);
		return erpResponse;
	}

	public ErpResponse processError(ErpResponse erpResponse) {
		if (!ApplicationConstant.EMPTY.equals(erpResponse.getMessage()) || erpResponse.getMessage() != null) {
			erpResponse.setMessage(erpResponse.getMessage());
		} else {
			erpResponse.setMessage(ApplicationConstant.ERROR_MESSAGE);
		}
		return erpResponse;
	}

	public ResponseEntity<ErpResponse> process(int code, ErpResponse erpResponse) {
		ResponseEntity<ErpResponse> responseEntity = null;
		if (erpResponse == null) {
			erpResponse = new ErpResponse();
		}

		switch (code) {
		case 0:
			erpResponse.setStatusCode(ApplicationConstant.STATUS_CODE_FAIL);
			erpResponse.setMessage(ApplicationConstant.STATUS_MESSAGE_CODE_EXCEPTION);
			responseEntity = new ResponseEntity<ErpResponse>(erpResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		case 1:
			erpResponse.setStatusCode(ApplicationConstant.STATUS_CODE_SUCCESS);
			erpResponse.setMessage(ApplicationConstant.SUCCESS_MESSAGE);
			responseEntity = new ResponseEntity<ErpResponse>(erpResponse, HttpStatus.OK);
			break;
		case 2:
			erpResponse.setStatusCode(ApplicationConstant.STATUS_CODE_PERMISSION_DENIED);
			erpResponse.setMessage(ApplicationConstant.PERMISSION_DENIED);
			responseEntity = new ResponseEntity<ErpResponse>(erpResponse, HttpStatus.FORBIDDEN);
			break;
		}

		return responseEntity;
	}
}
