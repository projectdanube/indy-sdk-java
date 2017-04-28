package com.danubetech.libsovrin.pool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.danubetech.libsovrin.ErrorCode;
import com.danubetech.libsovrin.LibSovrin;
import com.danubetech.libsovrin.SovrinException;

import jnr.ffi.Address;

public class PoolImpl implements Pool {

	public PoolImpl() {

	}

	public Future<CreatePoolLedgerConfigResult> createPoolLedgerConfig(
			String configName,
			String config) throws SovrinException {

		final CompletableFuture<CreatePoolLedgerConfigResult> future = new CompletableFuture<> ();

		LibSovrin.sovrin_create_pool_ledger_config_Closure closure = new LibSovrin.sovrin_create_pool_ledger_config_Closure() {

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
				Address.valueOf(closure.handle().getAddress()));

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);

		return future;
	}

	public Future<OpenPoolLedgerResult> openPoolLedger(
			String configName,
			String config) throws SovrinException {

		final CompletableFuture<OpenPoolLedgerResult> future = new CompletableFuture<> ();

		LibSovrin.sovrin_open_pool_ledger_Closure closure = new LibSovrin.sovrin_open_pool_ledger_Closure() {

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
				closure.address());

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);

		return future;
	}

	public Future<RefreshPoolLedgerResult> refreshPoolLedger(
			int handle) throws SovrinException {

		final CompletableFuture<RefreshPoolLedgerResult> future = new CompletableFuture<> ();

		LibSovrin.sovrin_refresh_pool_ledger_Closure closure = new LibSovrin.sovrin_refresh_pool_ledger_Closure() {

			public void invoke(int xcommand_handle, int err) {

				ErrorCode errorCode = ErrorCode.valueOf(err);
				if (! ErrorCode.Success.equals(errorCode)) { future.completeExceptionally(SovrinException.fromErrorCode(errorCode)); return; }

				RefreshPoolLedgerResult result = new RefreshPoolLedgerResult();
				future.complete(result);
			}
		};

		int result = LibSovrin.api.sovrin_refresh_pool_ledger(
				0, 
				handle, 
				closure.address());

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);

		return future;
	}

	public Future<ClosePoolLedgerResult> closePoolLedger(
			int handle) throws SovrinException {

		final CompletableFuture<ClosePoolLedgerResult> future = new CompletableFuture<> ();

		LibSovrin.sovrin_close_pool_ledger_Closure closure = new LibSovrin.sovrin_close_pool_ledger_Closure() {

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
				closure.address());

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);

		return future;
	}

	public Future<DeletePoolLedgerConfigResult> deletePoolLedgerConfig(
			String configName) throws SovrinException {

		final CompletableFuture<DeletePoolLedgerConfigResult> future = new CompletableFuture<> ();

		LibSovrin.sovrin_delete_pool_ledger_config_Closure closure = new LibSovrin.sovrin_delete_pool_ledger_config_Closure() {

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
				closure.address());

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);

		return future;
	}
}
