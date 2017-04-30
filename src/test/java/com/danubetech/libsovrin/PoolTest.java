package com.danubetech.libsovrin;

import java.io.File;
import java.util.concurrent.Future;

import org.junit.Assert;

import com.danubetech.libsovrin.pool.Pool;
import com.danubetech.libsovrin.pool.Pool.CreatePoolLedgerConfigResult;
import com.danubetech.libsovrin.pool.Pool.OpenPoolLedgerResult;
import com.danubetech.libsovrin.pool.PoolImpl;

import junit.framework.TestCase;

public class PoolTest extends TestCase {

	private static Pool pool = new PoolImpl();

	@Override
	protected void setUp() throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));
	}

	@Override
	protected void tearDown() throws Exception {

	}

	public void testCreatePoolLedgerConfig() throws Exception {

		Future<CreatePoolLedgerConfigResult> future = pool.createPoolLedgerConfig("myconfig", null);
		CreatePoolLedgerConfigResult result = future.get();
		Assert.assertNotNull(result);
	}

	public void testOpenPoolLedger() throws Exception {

		Future<OpenPoolLedgerResult> future = pool.openPoolLedger("myconfig", null);
		OpenPoolLedgerResult result = future.get();
		Assert.assertNotNull(result);
	}
}
