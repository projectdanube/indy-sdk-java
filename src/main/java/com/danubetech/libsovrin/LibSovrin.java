package com.danubetech.libsovrin;

import java.io.File;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;

public abstract class LibSovrin {

	public static final String LIBRARY_NAME = "sovrin";

	/*
	 * Native library interface
	 */

	public interface API extends Library {

		// pool.rs

		public int sovrin_create_pool_ledger_config(int command_handle, String config_name, String config, Callback cb);
		public int sovrin_open_pool_ledger(int command_handle, String config_name, String config, Callback cb);
		public int sovrin_refresh_pool_ledger(int command_handle, int handle, Callback cb);
		public int sovrin_close_pool_ledger(int command_handle, int handle, Callback cb);
		public int sovrin_delete_pool_ledger_config(int command_handle, String config_name, Callback cb);

		// ledger.rs

		public int sign_and_submit_request(int command_handle, int wallet_handle, String submitter_did, String request_json, Callback cb);
		public int submit_request(int command_handle, int pool_handle, String request_json, Callback cb);
		public int build_get_ddo_request(int command_handle, String submitter_did, String target_did, String verkey, String xref, String data, String role, Callback cb);
		public int build_nym_request(int command_handle, String submitter_did, String target_did, Callback cb);
		public int build_attrib_request(int command_handle, String submitter_did, String target_did, String hash, String raw, String enc, Callback cb);
		public int build_get_attrib_request(int command_handle, String submitter_did, String target_did, String data, Callback cb);
		public int build_get_nym_request(int command_handle, String submitter_did, String target_did, Callback cb);
		public int build_schema_request(int command_handle, String submitter_did, String data, Callback cb);
		public int build_get_schema_request(int command_handle, String submitter_did, String data, Callback cb);
		public int build_claim_def_txn(int command_handle, String submitter_did, String xref, String data, Callback cb);
		public int build_get_claim_def_txn(int command_handle, String submitter_did, String xref, Callback cb);
		public int build_node_request(int command_handle, String submitter_did, String target_did, String data, Callback cb);

	}

	/*
	 * Initialization
	 */

	public static API api = null;

	static {

		try {

			init();

		} catch (UnsatisfiedLinkError ex) {

			// Library could not be found in standard OS locations.
			// Call init(File file) explicitly with absolute library path.
		}
	}

	public static void init(File file) {

		api = Native.loadLibrary(file.getAbsolutePath(), API.class);
	}

	public static void init() {

		api = Native.loadLibrary(LIBRARY_NAME, API.class);
	}

	public static boolean isInitialized() {

		return api != null;
	}
}
