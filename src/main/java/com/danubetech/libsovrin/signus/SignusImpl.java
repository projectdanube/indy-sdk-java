package com.danubetech.libsovrin.signus;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.danubetech.libsovrin.LibSovrin;
import com.danubetech.libsovrin.SovrinException;
import com.danubetech.libsovrin.SovrinModule;
import com.sun.jna.Callback;

public class SignusImpl extends SovrinModule implements Signus {

	public SignusImpl() {

	}

	@Override
	public Future<CreateAndStoreMyDidResult> createAndStoreMyDid(
			int walletHandle,
			String didJson) throws SovrinException {

		final CompletableFuture<CreateAndStoreMyDidResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, String did, String verkey, String pk) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				CreateAndStoreMyDidResult result = new CreateAndStoreMyDidResult(did, verkey, pk);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_create_and_store_my_did(
				FIXED_COMMAND_HANDLE, 
				walletHandle, 
				didJson,
				callback);

		checkResult(result);

		return future;
	}

	@Override
	public Future<ReplaceKeysResult> replaceKeys(
			int walletHandle,
			String did,
			String identityJson) throws SovrinException {

		final CompletableFuture<ReplaceKeysResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, String verkey, String pk) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				ReplaceKeysResult result = new ReplaceKeysResult(verkey, pk);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_replace_keys(
				FIXED_COMMAND_HANDLE, 
				walletHandle, 
				did,
				identityJson,
				callback);

		checkResult(result);

		return future;
	}

	@Override
	public Future<StoreTheirDidResult> storeTheirDid(
			int walletHandle,
			String identityJson) throws SovrinException {

		final CompletableFuture<StoreTheirDidResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				StoreTheirDidResult result = new StoreTheirDidResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_store_their_did(
				FIXED_COMMAND_HANDLE, 
				walletHandle, 
				identityJson,
				callback);

		checkResult(result);

		return future;
	}

	@Override
	public Future<SignResult> sign(
			int walletHandle,
			String did,
			String msg) throws SovrinException {

		final CompletableFuture<SignResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, String signature) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				SignResult result = new SignResult(signature);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_sign(
				FIXED_COMMAND_HANDLE, 
				walletHandle, 
				did,
				msg,
				callback);

		checkResult(result);

		return future;
	}

	@Override
	public Future<VerifySignatureResult> verifySignature(
			int walletHandle,
			String did,
			String msg,
			String signature) throws SovrinException {

		final CompletableFuture<VerifySignatureResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, boolean valid) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				VerifySignatureResult result = new VerifySignatureResult(valid);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_verify_signature(
				FIXED_COMMAND_HANDLE, 
				walletHandle, 
				did,
				msg,
				signature,
				callback);

		checkResult(result);

		return future;
	}

	@Override
	public Future<EncryptResult> encrypt(
			int walletHandle,
			String did,
			String msg) throws SovrinException {

		final CompletableFuture<EncryptResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, String encryptedMsg) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				EncryptResult result = new EncryptResult(encryptedMsg);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_encrypt(
				FIXED_COMMAND_HANDLE, 
				walletHandle, 
				did,
				msg,
				callback);

		checkResult(result);

		return future;
	}

	@Override
	public Future<DecryptResult> decrypt(
			int walletHandle,
			String did,
			String encryptedMsg) throws SovrinException {

		final CompletableFuture<DecryptResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, String decryptedMsg) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				DecryptResult result = new DecryptResult(decryptedMsg);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_decrypt(
				FIXED_COMMAND_HANDLE, 
				walletHandle, 
				did,
				encryptedMsg,
				callback);

		checkResult(result);

		return future;
	}
}
