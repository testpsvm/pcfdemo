package com.pcfdemo.controller;

/**
 * This class is used to return message 
 *
 */
public class RestResponse {

	/** The message to return */
	private String message;

	/**
	 * Default constructor
	 * 
	 * @param pMessage
	 */
	public RestResponse(String pMessage) {
		message = pMessage;
	}

	/**
	 * Returns the message
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
