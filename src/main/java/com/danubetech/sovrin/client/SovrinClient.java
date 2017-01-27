package com.danubetech.sovrin.client;

import java.io.Closeable;

public interface SovrinClient extends Closeable {

	public void close();
	public int setDid(String dest, String verKey, String xref, String data, String role);
}
