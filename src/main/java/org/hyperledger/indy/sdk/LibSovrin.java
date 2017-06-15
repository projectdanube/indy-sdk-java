package org.hyperledger.indy.sdk;

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

		// wallet.rs

		public int sovrin_create_wallet(int command_handle, String pool_name, String name, String xtype, String config, String credentials, Callback cb);
		public int sovrin_open_wallet(int command_handle, String name, String runtime_config, String credentials, Callback cb);
		public int sovrin_close_wallet(int command_handle, int handle, Callback cb);
		public int sovrin_delete_wallet(int command_handle, String name, String credentials, Callback cb);
		public int sovrin_wallet_set_seq_no_for_value(int command_handle, int wallet_handle, String wallet_key, Callback cb);

		// ledger.rs

		public int sovrin_sign_and_submit_request(int command_handle, int pool_handle, int wallet_handle, String submitter_did, String request_json, Callback cb);
		public int sovrin_submit_request(int command_handle, int pool_handle, String request_json, Callback cb);
		public int sovrin_build_get_ddo_request(int command_handle, String submitter_did, String target_did, Callback cb);
		public int sovrin_build_nym_request(int command_handle, String submitter_did, String target_did, String verkey, String alias, String role, Callback cb);
		public int sovrin_build_attrib_request(int command_handle, String submitter_did, String target_did, String hash, String raw, String enc, Callback cb);
		public int sovrin_build_get_attrib_request(int command_handle, String submitter_did, String target_did, String data, Callback cb);
		public int sovrin_build_get_nym_request(int command_handle, String submitter_did, String target_did, Callback cb);
		public int sovrin_build_schema_request(int command_handle, String submitter_did, String data, Callback cb);
		public int sovrin_build_get_schema_request(int command_handle, String submitter_did, String data, Callback cb);
		public int sovrin_build_claim_def_txn(int command_handle, String submitter_did, String xref, String data, Callback cb);
		public int sovrin_build_get_claim_def_txn(int command_handle, String submitter_did, String xref, Callback cb);
		public int sovrin_build_node_request(int command_handle, String submitter_did, String target_did, String data, Callback cb);

		// signus.rs

		public int sovrin_create_and_store_my_did(int command_handle, int wallet_handle, String did_json, Callback cb);
		public int sovrin_replace_keys(int command_handle, int wallet_handle, String did, String identity_json, Callback cb);
		public int sovrin_store_their_did(int command_handle, int wallet_handle, String identity_json, Callback cb);
		public int sovrin_sign(int command_handle, int wallet_handle, String did, String msg, Callback cb);
		public int sovrin_verify_signature(int command_handle, int wallet_handle, int pool_handle, String did, String signed_msg, Callback cb);
		public int sovrin_encrypt(int command_handle, int wallet_handle, String did, String msg, Callback cb);
		public int sovrin_decrypt(int command_handle, int wallet_handle, String did, String encrypted_msg, Callback cb);

		// anoncreds.rs

		public int sovrin_issuer_create_and_store_claim_def(int command_handle, int wallet_handle, String schema_json, String signature_type, boolean create_non_revoc, Callback cb);
		public int sovrin_issuer_create_and_store_revoc_reg(int command_handle, int wallet_handle, int claim_def_seq_no, int max_claim_num, Callback cb);
		public int sovrin_issuer_create_claim(int command_handle, int wallet_handle, String claim_req_json, String claim_json, int revoc_reg_seq_no, int user_revoc_index, Callback cb);
		public int sovrin_issuer_revoke_claim(int command_handle, int wallet_handle, int claim_def_seq_no, int revoc_reg_seq_no, int user_revoc_index, Callback cb);
		public int sovrin_prover_store_claim_offer(int command_handle, int wallet_handle, String claim_offer_json, Callback cb);
		public int sovrin_prover_get_claim_offers(int command_handle, int wallet_handle, String filter_json, Callback cb);
		public int sovrin_prover_create_master_secret(int command_handle, int wallet_handle, String master_secret_name, Callback cb);
		public int sovrin_prover_create_and_store_claim_req(int command_handle, int wallet_handle, String prover_did, String claim_offer_json, String claim_def_json, String master_secret_name, Callback cb);
		public int sovrin_prover_store_claim(int command_handle, int wallet_handle, String claims_json, Callback cb);
		public int sovrin_prover_get_claims(int command_handle, int wallet_handle, String filter_json, Callback cb);
		public int sovrin_prover_get_claims_for_proof_req(int command_handle, int wallet_handle, String proof_request_json, Callback cb);
		public int sovrin_prover_create_proof(int command_handle, int wallet_handle, String proof_req_json, String requested_claims_json, String schemas_json, String master_secret_name, String claim_defs_json, String revoc_regs_json, Callback cb);
		public int sovrin_verifier_verify_proof(int command_handle, int wallet_handle, String proof_request_json, String proof_json, String schemas_json, String claim_defs_jsons, String revoc_regs_json, Callback cb);
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
