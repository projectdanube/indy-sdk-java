package com.danubetech.libsovrin;

import java.io.File;
import java.util.concurrent.Future;

import org.junit.Assert;

import com.danubetech.libsovrin.pool.Pool;
import com.danubetech.libsovrin.pool.PoolOptions.OpenPoolLedgerOptions;
import com.danubetech.libsovrin.signus.Signus;
import com.danubetech.libsovrin.signus.SignusResults.CreateAndStoreMyDidResult;
import com.danubetech.libsovrin.signus.SignusResults.ReplaceKeysResult;
import com.danubetech.libsovrin.wallet.Wallet;

import junit.framework.TestCase;

public class SignusTest extends TestCase {

	private Pool pool;
	private Wallet wallet;
	
	@Override
	protected void setUp() throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));

		OpenPoolLedgerOptions openPoolLedgerOptions = new OpenPoolLedgerOptions(null, null, null);
		this.pool = Pool.openPoolLedger("myconfig", openPoolLedgerOptions).get().getPool();
		this.wallet = Wallet.openWallet("mywallet", null, null).get().getWallet();
	}

	@Override
	protected void tearDown() throws Exception {

		this.wallet.closeWallet();
		this.pool.closePoolLedger();
		Wallet.deleteWallet("mywallet", null);
	}

	public void testSignus() throws Exception {

		Future<CreateAndStoreMyDidResult> future1 = Signus.createAndStoreMyDid(this.wallet, "{}");
		CreateAndStoreMyDidResult result1 = future1.get();
		Assert.assertNotNull(result1);
		String did1 = result1.getDid();
		String verkey1 = result1.getVerkey();
		String pk1 = result1.getPk();
		Assert.assertNotNull(did1);
		Assert.assertNotNull(verkey1);
		Assert.assertNotNull(pk1);
		System.out.println(did1);
		System.out.println(verkey1);
		System.out.println(pk1);

		Future<ReplaceKeysResult> future2 = Signus.replaceKeys(this.wallet, did1, "{}");
		ReplaceKeysResult result2 = future2.get();
		Assert.assertNotNull(result2);
		String verkey2 = result2.getVerkey();
		String pk2 = result2.getPk();
		Assert.assertNotNull(verkey2);
		Assert.assertNotNull(pk2);
		Assert.assertNotEquals(verkey2, verkey1);
	}
}
