package com.danubetech.sovrin.client;

import static java.lang.System.mapLibraryName;

import java.io.File;

import jnr.ffi.LibraryLoader;

public abstract class NativeSovrinClient {

	public static final String LIBRARY_NAME = "sovclient";

	public interface Client {

		public int init_client(String hostAndPort);
		public int release_client(int clientId);
		public int set_did(int clientId, String dest, String verKey, String xref, String data, String role);
		public void get_did(int clientId, String did);
		public void set_attr(int clientId, String dest, String hash, String raw, String enc);
		public void get_attr(int clientId);
		public void set_schema(int clientId);
		public void get_schema(int clientId);
		public void set_issuer_key(int clientId);
		public void get_issuer_key(int clientId);
	}

	public static Client client;

	static {

		init();
	}

	public static void init(File file) {

		client = LibraryLoader.create(Client.class).load(file.getAbsolutePath());
	}

	public static void init() {

		File sovclient = new File("./lib/" + mapLibraryName(LIBRARY_NAME));

		init(sovclient);
	}
}
