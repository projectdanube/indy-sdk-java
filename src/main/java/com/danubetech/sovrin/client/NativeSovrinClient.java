package com.danubetech.sovrin.client;

import static java.lang.System.mapLibraryName;

import java.io.File;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Pointer;

public abstract class NativeSovrinClient {

	public static final String LIBRARY_NAME = "sovclient";

	public interface Client {

		public int init_client(String hostAndPort);
		public int release_client(int client_id);
		public int set_did(int client_id, String did, String verkey, String xref, String data, String role);
		public Pointer get_verkey(int client_id, String did);
		public Pointer get_ddo(int client_id, String did);
		public void free_str(Pointer c_ptr);
		public int set_attr(int client_id, String did, byte[] hash, byte[] raw, byte[] enc);
		public Pointer get_attr(int client_id, String did, String attr_name);
		public int set_schema(int client_id, String schema);
		public Pointer get_schema(int client_id);
		public int set_issuer_key(int client_id, byte[] issuer_key);
		public Pointer get_issuer_key(int client_id);
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
