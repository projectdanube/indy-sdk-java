package com.danubetech.libsovrin;

import java.io.File;
import java.util.concurrent.Future;

import org.junit.Assert;

import com.danubetech.libsovrin.LibSovrin;
import com.danubetech.libsovrin.wallet.Wallet;
import com.danubetech.libsovrin.wallet.Wallet.CloseWalletResult;
import com.danubetech.libsovrin.wallet.Wallet.CreateWalletResult;
import com.danubetech.libsovrin.wallet.Wallet.DeleteWalletResult;
import com.danubetech.libsovrin.wallet.Wallet.OpenWalletResult;
import com.danubetech.libsovrin.wallet.WalletImpl;

import junit.framework.TestCase;

public class WalletTest extends TestCase {

	private static Wallet wallet = new WalletImpl();

	@Override
	protected void setUp() throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));
	}

	@Override
	protected void tearDown() throws Exception {

	}

	public void testWallet() throws Exception {

		Future<CreateWalletResult> future1 = wallet.createWallet("default", "mywallet", null, null, null);
		CreateWalletResult result1 = future1.get();
		Assert.assertNotNull(result1);

		Future<OpenWalletResult> future2 = wallet.openWallet(0, "mywallet", null, null);
		OpenWalletResult result2 = future2.get();
		Assert.assertNotNull(result2);
		int handle = result2.getHandle();

		Future<CloseWalletResult> future3 = wallet.closeWallet(handle);
		CloseWalletResult result3 = future3.get();
		Assert.assertNotNull(result3);

		Future<DeleteWalletResult> future4 = wallet.deleteWallet("mywallet");
		DeleteWalletResult result4 = future4.get();
		Assert.assertNotNull(result4);
	}
}
