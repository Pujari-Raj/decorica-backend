
package com.homedecor.rest.common.exceptions;


public class CustomGenericException extends Exception{

	private static final long serialVersionUID = 1L;

	private String code;
	private String errorMessage;	

	/**
	 * @param code
	 * @param errorMessage
	 */
	public CustomGenericException(String code, String errorMessage) {
		this.setCode(code);
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the errorCode to set
	 */
	
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}
