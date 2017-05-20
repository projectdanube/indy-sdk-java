package com.danubetech.libsovrin;

import java.io.File;

import org.junit.Assert;

import com.danubetech.libsovrin.ledger.Ledger;
import com.danubetech.libsovrin.ledger.LedgerResults.BuildGetDdoRequestResult;
import com.danubetech.libsovrin.ledger.LedgerResults.BuildGetNymRequestResult;
import com.danubetech.libsovrin.pool.Pool;
import com.danubetech.libsovrin.pool.PoolJSONParameters.OpenPoolLedgerJSONParameter;

import junit.framework.TestCase;

public class LedgerTest extends TestCase {

	private Pool pool;

	@Override
	protected void setUp() throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));

		OpenPoolLedgerJSONParameter openPoolLedgerOptions = new OpenPoolLedgerJSONParameter(null, null, null);
		this.pool = Pool.openPoolLedger("myconfig", openPoolLedgerOptions).get().getPool();
	}

	@Override
	protected void tearDown() throws Exception {

		this.pool.closePoolLedger();
	}

	public void testLedger() throws Exception {

		BuildGetDdoRequestResult result1 = Ledger.buildGetDdoRequest("did:sov:21tDAKCERh95uGgKbJNHYp", "did:sov:1yvXbmgPoUm4dl66D7KhyD", "{}").get();
		Assert.assertNotNull(result1);
		String requestJson1 = result1.getRequestJson();
		Assert.assertNotNull(requestJson1);

		BuildGetNymRequestResult result2 = Ledger.buildGetNymRequest("did:sov:21tDAKCERh95uGgKbJNHYp", "did:sov:1yvXbmgPoUm4dl66D7KhyD").get();
		Assert.assertNotNull(result2);
		String requestJson2 = result2.getRequestJson();
		Assert.assertNotNull(requestJson2);
	}
}
