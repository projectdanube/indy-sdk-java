package com.danubetech.libsovrin;

public abstract class SovrinJsonOptions {

	public abstract String toJson();

	protected static String escapeJson(String string) {

		return string.replace("\\", "\\\\").replace("\"", "\\\"");
	}
}
