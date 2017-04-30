package com.danubetech.libsovrin.pool;

import java.util.concurrent.Future;

import com.danubetech.libsovrin.SovrinJsonOptions;
import com.danubetech.libsovrin.SovrinException;

public interface Pool {

	/*
	 * Methods
	 */

	public Future<CreatePoolLedgerConfigResult> createPoolLedgerConfig(
			String configName,
			CreatePoolLedgerConfigOptions config) throws SovrinException;

	public Future<OpenPoolLedgerResult> openPoolLedger(
			String configName,
			OpenPoolLedgerOptions config) throws SovrinException;

	public Future<RefreshPoolLedgerResult> refreshPoolLedger(
			int handle) throws SovrinException;

	public Future<ClosePoolLedgerResult> closePoolLedger(
			int handle) throws SovrinException;

	public Future<DeletePoolLedgerConfigResult> deletePoolLedgerConfig(
			String configName) throws SovrinException;

	/*
	 * Options
	 */

	public static class CreatePoolLedgerConfigOptions extends SovrinJsonOptions {

		public CreatePoolLedgerConfigOptions(String genesisTxn) {

			if (genesisTxn != null) this.map.put("genesis_txn", genesisTxn);
		}
	}

	public static class OpenPoolLedgerOptions extends SovrinJsonOptions {

		public OpenPoolLedgerOptions(Boolean refreshOnOpen, Boolean autoRefreshTime, Integer networkTimeout) {

			if (refreshOnOpen != null) this.map.put("refreshOnOpen", refreshOnOpen);
			if (autoRefreshTime != null) this.map.put("autoRefreshTime", autoRefreshTime);
			if (networkTimeout != null) this.map.put("networkTimeout", networkTimeout);
		}
	}

	/*
	 * Results
	 */

	public static class CreatePoolLedgerConfigResult {

		CreatePoolLedgerConfigResult() { }
	}

	public static class OpenPoolLedgerResult {

		private int poolHandle;
		OpenPoolLedgerResult(int poolHandle) { this.poolHandle = poolHandle; }
		public int getPoolHandle() { return this.poolHandle; }
	}

	public static class RefreshPoolLedgerResult {

		RefreshPoolLedgerResult() { }
	}

	public static class ClosePoolLedgerResult {

		ClosePoolLedgerResult() { }
	}

	public static class DeletePoolLedgerConfigResult {

		DeletePoolLedgerConfigResult() { }
	}
}
