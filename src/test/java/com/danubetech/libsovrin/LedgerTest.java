package com.danubetech.libsovrin;

import java.io.File;
import java.util.concurrent.Future;

import org.junit.Assert;

import com.danubetech.libsovrin.ledger.Ledger;
import com.danubetech.libsovrin.ledger.Ledger.BuildGetDdoRequestResult;
import com.danubetech.libsovrin.ledger.Ledger.BuildGetNymRequestResult;
import com.danubetech.libsovrin.ledger.LedgerImpl;
import com.danubetech.libsovrin.pool.Pool;
import com.danubetech.libsovrin.pool.PoolImpl;

import junit.framework.TestCase;

public class LedgerTest extends TestCase {

	private static Pool pool = new PoolImpl();
	private static Ledger ledger = new LedgerImpl();

	private int poolHandle;

	@Override
	protected void setUp() throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));

/*		CreatePoolLedgerConfigOptions config1 = new CreatePoolLedgerConfigOptions(null);
		pool.createPoolLedgerConfig("myconfig", null).get();
		this.poolHandle = pool.openPoolLedger("myconfig", null).get().getPoolHandle();*/
	}

	@Override
	protected void tearDown() throws Exception {

//		pool.closePoolLedger(this.poolHandle);
	}

	public void testLedger() throws Exception {

		Future<BuildGetDdoRequestResult> future1 = ledger.buildGetDdoRequest("did:sov:21tDAKCERh95uGgKbJNHYp", "did:sov:1yvXbmgPoUm4dl66D7KhyD", "{}");
		BuildGetDdoRequestResult result1 = future1.get();
		Assert.assertNotNull(result1);
		String requestJson1 = result1.getRequestJson();
		Assert.assertNotNull(requestJson1);

		Future<BuildGetNymRequestResult> future2 = ledger.buildGetNymRequest("did:sov:21tDAKCERh95uGgKbJNHYp", "did:sov:1yvXbmgPoUm4dl66D7KhyD");
		BuildGetNymRequestResult result2 = future2.get();
		Assert.assertNotNull(result2);
		String requestJson2 = result2.getRequestJson();
		Assert.assertNotNull(requestJson1);
	}
}
