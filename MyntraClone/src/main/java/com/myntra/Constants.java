package com.myntra;

public class Constants {

	/**
	 * @param JWT Token Validity in Millisecond.
	 */
	public static final Long JWT_VALIDITY = 1000 * 30L;
	public static final String JWT_SECRET = "YhiD5iVhUuArth8thDavM/H7LH6oGAck6QTbkIfTXcLEG+hRWsVmUou+XoyfiIND";
	public static final String JWT_HEADER_PREFIX = "Bearer ";
	/**
	 * @param Refresh Token Validity in Millisecond.
	 */
	public static final int REFRESH_TOKEN_VALIDITY = 1000 * 60;
	/**
	 * @param Email OTP Validity in Minute.
	 */
	public static final Long OTP_VALIDITY = 5L;

}
