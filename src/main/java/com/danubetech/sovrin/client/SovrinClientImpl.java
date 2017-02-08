package com.danubetech.sovrin.client;

import jnr.ffi.Pointer;

public class SovrinClientImpl implements SovrinClient {

	private String hostAndPort;
	private int clientId;

	public SovrinClientImpl(String hostAndPort) {

		this.hostAndPort = hostAndPort;

		this.init();
	}

	private void init() {

		NativeSovrinClient.client.init_client(
				this.hostAndPort);
	}

	public void close() {

		NativeSovrinClient.client.release_client(
				this.clientId);
	}

	@Override
	public int setDID(String did, String verKey, String xRef, String data, String role) {

		int result = NativeSovrinClient.client.set_did(
				this.clientId, 
				did, 
				verKey, 
				xRef, 
				data, 
				role);

		return result;
	}

	@Override
	public String getVerKey(String did) {

		Pointer result = NativeSovrinClient.client.get_verkey(
				this.clientId, 
				did);
		String string = result.getString(0);
		NativeSovrinClient.client.free_str(result);

		return string;
	}

	@Override
	public String getDDO(String did) {

		Pointer result = NativeSovrinClient.client.get_ddo(
				this.clientId, 
				did);
		String string = result.getString(0);
		NativeSovrinClient.client.free_str(result);

		return string;
	}

	@Override
	public int setAttr(String did, byte[] hash, byte[] raw, byte[] enc) {

		int result = NativeSovrinClient.client.set_attr(
				this.clientId, 
				did, 
				hash, 
				raw, 
				enc);

		return result;
	}

	@Override
	public String getAttr(String did, String attrName) {

		Pointer result = NativeSovrinClient.client.get_attr(
				this.clientId, 
				did, 
				attrName);
		String string = result.getString(0);
		NativeSovrinClient.client.free_str(result);

		return string;
	}

	@Override
	public int setSchema(String schema) {

		int result = NativeSovrinClient.client.set_schema(
				this.clientId, 
				schema);

		return result;
	}

	@Override
	public String getSchema() {

		Pointer result = NativeSovrinClient.client.get_schema(
				this.clientId);
		String string = result.getString(0);
		NativeSovrinClient.client.free_str(result);

		return string;
	}

	@Override
	public int setIssuerKey(byte[] issuerKey) {

		int result = NativeSovrinClient.client.set_issuer_key(
				this.clientId, 
				issuerKey == null ? null : issuerKey);

		return result;
	}

	@Override
	public String getIssuerKey() {

		Pointer result = NativeSovrinClient.client.get_issuer_key(
				this.clientId);
		String string = result.getString(0);
		NativeSovrinClient.client.free_str(result);

		return string;
	}

	/*
	 * Getters
	 */

	public String getHostAndPort() {

		return this.hostAndPort;
	}

	public int getClientId() {

		return this.clientId;
	}
}
