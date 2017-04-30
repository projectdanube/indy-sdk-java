package com.danubetech.libsovrin.ledger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.danubetech.libsovrin.LibSovrin;
import com.danubetech.libsovrin.SovrinException;
import com.danubetech.libsovrin.SovrinModule;
import com.sun.jna.Callback;

public class LedgerImpl extends SovrinModule implements Ledger {

	public LedgerImpl() {

	}

	public Future<SignAndSubmitRequestResult> signAndSubmitRequest(
			int walletHandle,
			String submitterDid,
			String requestJson) throws SovrinException {

		final CompletableFuture<SignAndSubmitRequestResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, String request_result_json) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				SignAndSubmitRequestResult result = new SignAndSubmitRequestResult(request_result_json);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sign_and_submit_request(
				FIXED_COMMAND_HANDLE, 
				walletHandle, 
				submitterDid,
				requestJson,
				callback);

		checkResult(result);

		return future;
	}

	public Future<SubmitRequestResult> submitRequest(
			int poolHandle,
			String requestJson) throws SovrinException {

		final CompletableFuture<SubmitRequestResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, String request_result_json) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				SubmitRequestResult result = new SubmitRequestResult(request_result_json);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.submit_request(
				FIXED_COMMAND_HANDLE, 
				poolHandle,
				requestJson,
				callback);

		checkResult(result);

		return future;
	}

	public Future<BuildGetDdoRequestResult> buildGetDdoRequest(
			String submitterDid,
			String targetDid,
			String requestJson) throws SovrinException {

		final CompletableFuture<BuildGetDdoRequestResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, String request_json) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				BuildGetDdoRequestResult result = new BuildGetDdoRequestResult(request_json);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.build_get_ddo_request(
				FIXED_COMMAND_HANDLE, 
				submitterDid,
				targetDid,
				callback);

		checkResult(result);

		return future;
	}

	public Future<BuildNymRequestResult> buildNymRequest(
			String submitterDid,
			String targetDid,
			String verkey,
			String xref,
			String data,
			String role) throws SovrinException {

		final CompletableFuture<BuildNymRequestResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, String request_json) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				BuildNymRequestResult result = new BuildNymRequestResult(request_json);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.build_nym_request(
				FIXED_COMMAND_HANDLE, 
				submitterDid,
				targetDid,
				verkey,
				xref,
				data,
				role,
				callback);

		checkResult(result);

		return future;
	}
}
