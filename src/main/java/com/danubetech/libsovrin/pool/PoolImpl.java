package com.danubetech.libsovrin.pool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.danubetech.libsovrin.LibSovrin;
import com.danubetech.libsovrin.SovrinException;
import com.sun.jna.Callback;

public class PoolImpl extends LibSovrin.SovrinModule implements Pool {

	public PoolImpl() {

	}

	public Future<CreatePoolLedgerConfigResult> createPoolLedgerConfig(
			String configName,
			String config) throws SovrinException {

		final CompletableFuture<CreatePoolLedgerConfigResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				CreatePoolLedgerConfigResult result = new CreatePoolLedgerConfigResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_create_pool_ledger_config(
				FIXED_COMMAND_HANDLE, 
				configName, 
				config, 
				callback);

		checkResult(result);

		return future;
	}

	public Future<OpenPoolLedgerResult> openPoolLedger(
			String configName,
			String config) throws SovrinException {

		final CompletableFuture<OpenPoolLedgerResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err, int pool_handle) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				OpenPoolLedgerResult result = new OpenPoolLedgerResult(pool_handle);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_create_pool_ledger_config(
				FIXED_COMMAND_HANDLE, 
				configName, 
				config, 
				callback);

		checkResult(result);

		return future;
	}

	public Future<RefreshPoolLedgerResult> refreshPoolLedger(
			int handle) throws SovrinException {

		final CompletableFuture<RefreshPoolLedgerResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				RefreshPoolLedgerResult result = new RefreshPoolLedgerResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_refresh_pool_ledger(
				FIXED_COMMAND_HANDLE, 
				handle, 
				callback);

		checkResult(result);

		return future;
	}

	public Future<ClosePoolLedgerResult> closePoolLedger(
			int handle) throws SovrinException {

		final CompletableFuture<ClosePoolLedgerResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				ClosePoolLedgerResult result = new ClosePoolLedgerResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_refresh_pool_ledger(
				FIXED_COMMAND_HANDLE, 
				handle, 
				callback);

		checkResult(result);

		return future;
	}

	public Future<DeletePoolLedgerConfigResult> deletePoolLedgerConfig(
			String configName) throws SovrinException {

		final CompletableFuture<DeletePoolLedgerConfigResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err) {

				if (! checkCallback(future, xcommand_handle, err)) return;

				DeletePoolLedgerConfigResult result = new DeletePoolLedgerConfigResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_delete_pool_ledger_config(
				FIXED_COMMAND_HANDLE, 
				configName, 
				callback);

		checkResult(result);

		return future;
	}
}
