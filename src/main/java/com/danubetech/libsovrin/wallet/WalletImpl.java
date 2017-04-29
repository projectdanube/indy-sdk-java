package com.danubetech.libsovrin.wallet;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.danubetech.libsovrin.LibSovrin;
import com.danubetech.libsovrin.SovrinException;
import com.sun.jna.Callback;

public class WalletImpl extends LibSovrin.SovrinModule implements Wallet {

	public WalletImpl() {

	}

	/* IMPLEMENT LATER
	 * public Future<...> registerWalletType(
				...) throws SovrinException;*/

	public Future<CreateWalletResult> createWallet(
			String poolName,
			String name,
			String xtype,
			String config,
			String credentials) throws SovrinException {

		final CompletableFuture<CreateWalletResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				CreateWalletResult result = new CreateWalletResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_create_wallet(
				FIXED_COMMAND_HANDLE, 
				poolName, 
				name,
				xtype,
				config,
				credentials,
				callback);

		checkResult(result);

		return future;
	}

	public Future<OpenWalletResult> openWallet(
			int poolHandle,
			String name,
			String config,
			String credentials) throws SovrinException {

		final CompletableFuture<OpenWalletResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, int handle) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				OpenWalletResult result = new OpenWalletResult(handle);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_open_wallet(
				FIXED_COMMAND_HANDLE, 
				poolHandle, 
				name,
				config,
				credentials,
				callback);

		checkResult(result);

		return future;
	}

	@Override
	public Future<CloseWalletResult> closeWallet(
			int handle) throws SovrinException {

		final CompletableFuture<CloseWalletResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				CloseWalletResult result = new CloseWalletResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_close_wallet(
				FIXED_COMMAND_HANDLE, 
				handle, 
				callback);

		checkResult(result);

		return future;
	}

	@Override
	public Future<DeleteWalletResult> deleteWallet(
			String name) throws SovrinException {

		final CompletableFuture<DeleteWalletResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				DeleteWalletResult result = new DeleteWalletResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_delete_wallet(
				FIXED_COMMAND_HANDLE, 
				name, 
				callback);

		checkResult(result);

		return future;
	}

	@Override
	public Future<WalletSetSeqNoForValueResult> walletSetSeqNoForValue(
			int walletHandle, 
			String walletKey,
			String configName) throws SovrinException {

		final CompletableFuture<WalletSetSeqNoForValueResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				WalletSetSeqNoForValueResult result = new WalletSetSeqNoForValueResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_wallet_set_seq_no_for_value(
				FIXED_COMMAND_HANDLE, 
				walletHandle,
				walletKey, 
				callback);

		checkResult(result);

		return future;
	}
}
