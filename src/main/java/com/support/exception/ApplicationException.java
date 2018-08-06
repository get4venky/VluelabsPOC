package com.support.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApplicationException extends RuntimeException {
    
    private HttpStatus httpStatus;
    private int errorCode;
    private String errorDescription;
    private String displayMessage;
    private Object data;
    
    
    
    public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getDisplayMessage() {
		return displayMessage;
	}

	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ApplicationException(int errorCode, String errorDescription) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.displayMessage = errorDescription;
    }
    
    public ApplicationException(int errorCode, String errorDescription, Object data) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.displayMessage = errorDescription;
        this.data = data;
    }
    
    public ApplicationException(int errorCode, String errorDescription, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.displayMessage = errorDescription;
    }
    
    public ApplicationException(int errorCode, String errorDescription, String displayMessage, Object data) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.displayMessage = displayMessage;
        this.data = data;
    }
    
    public ApplicationException(int errorCode, String errorDescription, HttpStatus httpStatus, String displayMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.displayMessage = displayMessage;
    }
    
    public ApplicationException(int errorCode, String errorDescription, HttpStatus httpStatus, Object data) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.data = data;
    }

}
