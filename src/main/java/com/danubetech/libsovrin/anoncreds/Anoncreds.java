package com.danubetech.libsovrin.anoncreds;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.danubetech.libsovrin.LibSovrin;
import com.danubetech.libsovrin.SovrinException;
import com.danubetech.libsovrin.SovrinJava;
import com.danubetech.libsovrin.anoncreds.AnoncredsResults.IssuerCreateAndStoreClaimDefResult;
import com.danubetech.libsovrin.wallet.Wallet;
import com.sun.jna.Callback;

/**
 * anoncreds.rs API
 */
public class Anoncreds extends SovrinJava.API {

	private Anoncreds() {

	}

	/*
	 * STATIC METHODS
	 */

	public static Future<IssuerCreateAndStoreClaimDefResult> issuerCreateAndStoreClaimDef(
			Wallet wallet,
			String schemaJson, 
			String signatureType, 
			boolean createNonRevoc) throws SovrinException {

		final CompletableFuture<IssuerCreateAndStoreClaimDefResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, String claim_def_json, String claim_def_uuid) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				IssuerCreateAndStoreClaimDefResult result = new IssuerCreateAndStoreClaimDefResult(claim_def_json, claim_def_uuid);
				future.complete(result);
			}
		};

		int walletHandle = wallet.getWalletHandle();

		int result = LibSovrin.api.sovrin_issuer_create_and_store_claim_def(
				FIXED_COMMAND_HANDLE, 
				walletHandle, 
				schemaJson,
				signatureType,
				createNonRevoc,
				callback);

		checkResult(result);

		return future;
	}
}
