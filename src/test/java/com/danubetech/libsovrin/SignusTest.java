package com.danubetech.libsovrin;

import java.io.File;
import java.util.concurrent.Future;

import org.junit.Assert;

import com.danubetech.libsovrin.signus.Signus;
import com.danubetech.libsovrin.signus.Signus.CreateAndStoreMyDidResult;
import com.danubetech.libsovrin.signus.Signus.ReplaceKeysResult;
import com.danubetech.libsovrin.signus.SignusImpl;
import com.danubetech.libsovrin.wallet.Wallet;
import com.danubetech.libsovrin.wallet.WalletImpl;

import junit.framework.TestCase;

public class SignusTest extends TestCase {

	private static Wallet wallet = new WalletImpl();
	private static Signus signus = new SignusImpl();

	private int handle;
	
	@Override
	protected void setUp() throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));

		wallet.createWallet("default", "mywallet", null, null, null).get();
		this.handle = wallet.openWallet(0, "mywallet", null, null).get().getHandle();
	}

	@Override
	protected void tearDown() throws Exception {

		wallet.closeWallet(this.handle);
		wallet.deleteWallet("mywallet");
	}

	public void testSignus() throws Exception {

		Future<CreateAndStoreMyDidResult> future1 = signus.createAndStoreMyDid(this.handle, "{}");
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

		Future<ReplaceKeysResult> future2 = signus.replaceKeys(this.handle, did1, "{}");
		ReplaceKeysResult result2 = future2.get();
		Assert.assertNotNull(result2);
		String verkey2 = result2.getVerkey();
		String pk2 = result2.getPk();
		Assert.assertNotNull(verkey2);
		Assert.assertNotNull(pk2);
		Assert.assertNotEquals(verkey2, verkey1);
	}
}
