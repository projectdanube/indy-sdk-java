package com.danubetech.libsovrin;

import java.io.File;

import org.junit.Assert;

import com.danubetech.libsovrin.pool.Pool;
import com.danubetech.libsovrin.pool.PoolOptions.OpenPoolLedgerOptions;
import com.danubetech.libsovrin.wallet.Wallet;
import com.danubetech.libsovrin.wallet.WalletResults.CloseWalletResult;
import com.danubetech.libsovrin.wallet.WalletResults.CreateWalletResult;
import com.danubetech.libsovrin.wallet.WalletResults.DeleteWalletResult;
import com.danubetech.libsovrin.wallet.WalletResults.OpenWalletResult;

import junit.framework.TestCase;

public class WalletTest extends TestCase {

	private Pool pool;
	
	@Override
	protected void setUp() throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));

		OpenPoolLedgerOptions openPoolLedgerOptions = new OpenPoolLedgerOptions(null, null, null);
		this.pool = Pool.openPoolLedger("myconfig", openPoolLedgerOptions).get().getPool();
	}

	@Override
	protected void tearDown() throws Exception {

		this.pool.closePoolLedger();
	}

	public void testWallet() throws Exception {

		Wallet wallet;
		
		CreateWalletResult result1 = Wallet.createWallet("default", "mywallet", null, null, null).get();
		Assert.assertNotNull(result1);

		OpenWalletResult result2 = Wallet.openWallet(this.pool, "mywallet", null, null).get();
		Assert.assertNotNull(result2);
		wallet = result2.getWallet();

		CloseWalletResult result3 = wallet.closeWallet().get();
		Assert.assertNotNull(result3);

		DeleteWalletResult result4 = Wallet.deleteWallet("mywallet").get();
		Assert.assertNotNull(result4);
	}
}
