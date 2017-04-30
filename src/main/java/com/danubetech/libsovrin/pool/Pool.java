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

		private String genesisTxn;

		public CreatePoolLedgerConfigOptions(String genesisTxn) {

			this.genesisTxn = genesisTxn;
		}

		public String toJson() {

			StringBuilder builder = new StringBuilder();
			builder.append("{");
			builder.append("\"genesis_txn\":\"" + escapeJson(this.genesisTxn) + "\"");
			builder.append("}");
			return builder.toString();
		}
	}

	public static class OpenPoolLedgerOptions extends SovrinJsonOptions {

		private boolean refreshOnOpen;
		private boolean autoRefreshTime;
		private int networkTimeout;

		public OpenPoolLedgerOptions(boolean refreshOnOpen, boolean autoRefreshTime, int networkTimeout) {

			this.refreshOnOpen = refreshOnOpen;
			this.autoRefreshTime = autoRefreshTime;
			this.networkTimeout = networkTimeout;
		}

		public String toJson() {

			StringBuilder builder = new StringBuilder();
			builder.append("{");
			builder.append("\"refreshOnOpen\":\"" + Boolean.toString(this.refreshOnOpen) + "\"");
			builder.append(",");
			builder.append("\"autoRefreshTime\":\"" + Boolean.toString(this.autoRefreshTime) + "\"");
			builder.append(",");
			builder.append("\"networkTimeout\":\"" + Integer.toString(this.networkTimeout) + "\"");
			builder.append("}");
			return builder.toString();
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
