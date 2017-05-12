package com.danubetech.libsovrin.pool;

import com.danubetech.libsovrin.SovrinJsonOptions;

/**
 * pool.rs Options
 */
public final class PoolOptions {

	private PoolOptions() {

	}

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
}
