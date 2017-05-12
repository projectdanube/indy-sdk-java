package com.danubetech.libsovrin.pool;

/**
 * pool.rs Results
 */
public final class PoolResults {

	private PoolResults() {

	}

	public static class CreatePoolLedgerConfigResult {

		CreatePoolLedgerConfigResult() { }
	}

	public static class OpenPoolLedgerResult {

		private Pool pool;
		OpenPoolLedgerResult(Pool pool) { this.pool = pool; }
		public Pool getPool() { return this.pool; }
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
