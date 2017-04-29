package com.danubetech.libsovrin;

import java.io.File;
import java.util.concurrent.Future;

import com.danubetech.libsovrin.LibSovrin;
import com.danubetech.libsovrin.pool.Pool;
import com.danubetech.libsovrin.pool.PoolImpl;
import com.danubetech.libsovrin.pool.Pool.CreatePoolLedgerConfigResult;
import com.danubetech.libsovrin.pool.Pool.OpenPoolLedgerResult;

import junit.framework.TestCase;

public class PoolTest extends TestCase {

	private Pool pool;

	@Override
	protected void setUp() throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));

		pool = new PoolImpl();
	}

	@Override
	protected void tearDown() throws Exception {

	}

	public void testCreatePoolLedgerConfig() throws Exception {

		Future<CreatePoolLedgerConfigResult> future = pool.createPoolLedgerConfig("myconfig", null);
		CreatePoolLedgerConfigResult result = future.get();
		assertNotNull(result);
	}

	public void testOpenPoolLedger() throws Exception {

		Future<OpenPoolLedgerResult> future = pool.openPoolLedger("myconfig", null);
		OpenPoolLedgerResult result = future.get();
		assertNotNull(result);
	}
}
