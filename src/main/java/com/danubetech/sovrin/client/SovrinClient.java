package com.danubetech.sovrin.client;

import java.io.Closeable;

public interface SovrinClient extends Closeable {

	public void close();
	public int setDID(String did, String verKey, String xRef, String data, String role);
	public String getVerKey(String did);
	public String getDDO(String did);
	public int setAttr(String did, byte[] hash, byte[] raw, byte[] enc);
	public String getAttr(String did, String attrName);
	public int setSchema(String schema);
	public String getSchema();
	public int setIssuerKey(byte[] issuerKey);
	public String getIssuerKey();
}
