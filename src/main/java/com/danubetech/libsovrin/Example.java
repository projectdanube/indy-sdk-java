package com.danubetech.libsovrin;

import java.io.File;

import com.danubetech.libsovrin.pool.Pool;
import com.danubetech.libsovrin.wallet.Wallet;

public class Example {

	public static void main(String[] args) throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));

		Pool pool = Pool.openPoolLedger("default", null).get().getPool();
		System.out.println("pool handle: " + pool.getPoolHandle());

		Wallet wallet = Wallet.openWallet("default", null, null).get().getWallet();
		System.out.println("wallet handle: " + wallet.getWalletHandle());
	}
}
