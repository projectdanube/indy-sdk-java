package com.danubetech.libsovrin.pool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.danubetech.libsovrin.ErrorCode;
import com.danubetech.libsovrin.LibSovrin;
import com.danubetech.libsovrin.SovrinException;
import com.sun.jna.Callback;

public class PoolImpl implements Pool {

	public PoolImpl() {

	}

	public Future<CreatePoolLedgerConfigResult> createPoolLedgerConfig(
			String configName,
			String config) throws SovrinException {

		final CompletableFuture<CreatePoolLedgerConfigResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void invoke(int xcommand_handle, int err) {

				ErrorCode errorCode = ErrorCode.valueOf(err);
				if (! ErrorCode.Success.equals(errorCode)) { future.completeExceptionally(SovrinException.fromErrorCode(errorCode)); return; }

				CreatePoolLedgerConfigResult result = new CreatePoolLedgerConfigResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_create_pool_ledger_config(
				0, 
				configName, 
				config, 
				callback);

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);

		return future;
	}

	public Future<OpenPoolLedgerResult> openPoolLedger(
			String configName,
			String config) throws SovrinException {

		final CompletableFuture<OpenPoolLedgerResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void invoke(int xcommand_handle, int err, int pool_handle) {

				ErrorCode errorCode = ErrorCode.valueOf(err);
				if (! ErrorCode.Success.equals(errorCode)) { future.completeExceptionally(SovrinException.fromErrorCode(errorCode)); return; }

				OpenPoolLedgerResult result = new OpenPoolLedgerResult(pool_handle);
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_create_pool_ledger_config(
				0, 
				configName, 
				config, 
				callback);

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);

		return future;
	}

	public Future<RefreshPoolLedgerResult> refreshPoolLedger(
			int handle) throws SovrinException {

		final CompletableFuture<RefreshPoolLedgerResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void callback(int xcommand_handle, int err) {

				ErrorCode errorCode = ErrorCode.valueOf(err);
				if (! ErrorCode.Success.equals(errorCode)) { future.completeExceptionally(SovrinException.fromErrorCode(errorCode)); return; }

				RefreshPoolLedgerResult result = new RefreshPoolLedgerResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_refresh_pool_ledger(
				0, 
				handle, 
				callback);

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);

		return future;
	}

	public Future<ClosePoolLedgerResult> closePoolLedger(
			int handle) throws SovrinException {

		final CompletableFuture<ClosePoolLedgerResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void invoke(int xcommand_handle, int err) {

				ErrorCode errorCode = ErrorCode.valueOf(err);
				if (! ErrorCode.Success.equals(errorCode)) { future.completeExceptionally(SovrinException.fromErrorCode(errorCode)); return; }

				ClosePoolLedgerResult result = new ClosePoolLedgerResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_refresh_pool_ledger(
				0, 
				handle, 
				callback);

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);

		return future;
	}

	public Future<DeletePoolLedgerConfigResult> deletePoolLedgerConfig(
			String configName) throws SovrinException {

		final CompletableFuture<DeletePoolLedgerConfigResult> future = new CompletableFuture<> ();

		Callback callback = new Callback() {

			@SuppressWarnings("unused")
			public void invoke(int xcommand_handle, int err) {

				ErrorCode errorCode = ErrorCode.valueOf(err);
				if (! ErrorCode.Success.equals(errorCode)) { future.completeExceptionally(SovrinException.fromErrorCode(errorCode)); return; }

				DeletePoolLedgerConfigResult result = new DeletePoolLedgerConfigResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_delete_pool_ledger_config(
				0, 
				configName, 
				callback);

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);

		return future;
	}
}
