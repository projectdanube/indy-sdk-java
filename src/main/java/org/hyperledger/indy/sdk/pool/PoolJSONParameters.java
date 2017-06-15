package org.hyperledger.indy.sdk.pool;

import org.hyperledger.indy.sdk.SovrinJava;

/**
 * pool.rs JSON parameters
 */
public final class PoolJSONParameters {

	private PoolJSONParameters() {

	}

	public static class CreatePoolLedgerConfigJSONParameter extends SovrinJava.JsonParameter {

		public CreatePoolLedgerConfigJSONParameter(String genesisTxn) {

			if (genesisTxn != null) this.map.put("genesis_txn", genesisTxn);
		}
	}

	public static class OpenPoolLedgerJSONParameter extends SovrinJava.JsonParameter {

		public OpenPoolLedgerJSONParameter(Boolean refreshOnOpen, Boolean autoRefreshTime, Integer networkTimeout) {

			if (refreshOnOpen != null) this.map.put("refreshOnOpen", refreshOnOpen);
			if (autoRefreshTime != null) this.map.put("autoRefreshTime", autoRefreshTime);
			if (networkTimeout != null) this.map.put("networkTimeout", networkTimeout);
		}
	}
}
