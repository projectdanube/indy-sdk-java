package com.danubetech.libsovrin;

public class SovrinException extends Exception {

	private static final long serialVersionUID = 2650355290834266477L;

	public SovrinException(String message) {

		super(message);
	}

	public static SovrinException fromErrorCode(ErrorCode errorCode) {

		return new SovrinException(errorCode.name() + ": " + errorCode.value());
	}
}