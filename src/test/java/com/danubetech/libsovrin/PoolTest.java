package com.danubetech.libsovrin;

import java.io.File;
import java.util.concurrent.Future;

import org.junit.Assert;

import com.danubetech.libsovrin.pool.Pool;
import com.danubetech.libsovrin.pool.PoolJSONParameters.OpenPoolLedgerJSONParameter;
import com.danubetech.libsovrin.pool.PoolResults.OpenPoolLedgerResult;

import junit.framework.TestCase;

public class PoolTest extends TestCase {

	@Override
	protected void setUp() throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));
	}

	@Override
	protected void tearDown() throws Exception {

	}

	public void testPool() throws Exception {

/*		CreatePoolLedgerConfigOptions config1 = new CreatePoolLedgerConfigOptions(null);
		Future<CreatePoolLedgerConfigResult> future1 = Pool.createPoolLedgerConfig("myconfig", config1);
		CreatePoolLedgerConfigResult result1 = future1.get();
		Assert.assertNotNull(result1);*/

		OpenPoolLedgerJSONParameter config2 = new OpenPoolLedgerJSONParameter(null, null, null);
		Future<OpenPoolLedgerResult> future2 = Pool.openPoolLedger("myconfig", config2);
		OpenPoolLedgerResult result2 = future2.get();
		Assert.assertNotNull(result2);
	}
}
