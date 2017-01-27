package com.danubetech.sovrin.client;

public class SovrinClientImpl implements SovrinClient {

	private String hostAndPort;
	private int clientId;

	public SovrinClientImpl(String hostAndPort) {

		this.hostAndPort = hostAndPort;

		this.init();
	}

	private void init() {

		NativeSovrinClient.client.init_client(this.hostAndPort);
	}

	public void close() {

		NativeSovrinClient.client.release_client(this.clientId);
	}

	@Override
	public int setDid(String dest, String verKey, String xref, String data, String role) {

		int result = NativeSovrinClient.client.set_did(this.clientId, dest, verKey, xref, data, role);

		return result;
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
