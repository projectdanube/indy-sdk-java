package com.danubetech.libsovrin.pool;

import java.util.concurrent.Future;

import com.danubetech.libsovrin.SovrinException;

public interface Pool {

	public Future<CreatePoolLedgerConfigResult> createPoolLedgerConfig(
			String configName,
			String config) throws SovrinException;

	public Future<OpenPoolLedgerResult> openPoolLedger(
			String configName,
			String config) throws SovrinException;

	public static class CreatePoolLedgerConfigResult {

		CreatePoolLedgerConfigResult() { }
	}

	public static class OpenPoolLedgerResult {

		private int poolHandle;
		OpenPoolLedgerResult(int poolHandle) { this.poolHandle = poolHandle; }
		public int getPoolHandle() { return this.poolHandle; }
	}
}
