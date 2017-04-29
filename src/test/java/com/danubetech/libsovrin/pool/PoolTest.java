package com.danubetech.libsovrin.pool;

import java.util.concurrent.Future;

import com.danubetech.libsovrin.LibSovrin;
import com.danubetech.libsovrin.pool.Pool.CreatePoolLedgerConfigResult;
import com.danubetech.libsovrin.pool.Pool.OpenPoolLedgerResult;

import junit.framework.TestCase;

public class PoolTest extends TestCase {

	private Pool pool;

	@Override
	protected void setUp() throws Exception {

		LibSovrin.init();

		pool = new PoolImpl();
	}

	@Override
	protected void tearDown() throws Exception {

	}

	public void testCreatePoolLedgerConfig() throws Exception {

		Future<CreatePoolLedgerConfigResult> future = pool.createPoolLedgerConfig("default", "testconfig");
		CreatePoolLedgerConfigResult result = future.get();
		assertNotNull(result);
	}

	public void testOpenPoolLedger() throws Exception {

		Future<OpenPoolLedgerResult> future = pool.openPoolLedger("default", "testconfig");
		OpenPoolLedgerResult result = future.get();
		assertNotNull(result);
	}
}
