package com.danubetech.libsovrin.pool;

import com.danubetech.libsovrin.SovrinJava;

/**
 * pool.rs Results
 */
public final class PoolResults {

	private PoolResults() {

	}

	public static class CreatePoolLedgerConfigResult implements SovrinJava.Result {

		CreatePoolLedgerConfigResult() { }
	}

	public static class OpenPoolLedgerResult implements SovrinJava.Result {

		private Pool pool;
		OpenPoolLedgerResult(Pool pool) { this.pool = pool; }
		public Pool getPool() { return this.pool; }
	}

	public static class RefreshPoolLedgerResult implements SovrinJava.Result {

		RefreshPoolLedgerResult() { }
	}

	public static class ClosePoolLedgerResult implements SovrinJava.Result {

		ClosePoolLedgerResult() { }
	}

	public static class DeletePoolLedgerConfigResult implements SovrinJava.Result {

		DeletePoolLedgerConfigResult() { }
	}
}
