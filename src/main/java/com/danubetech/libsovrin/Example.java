package com.danubetech.libsovrin;

import java.io.File;
import java.util.concurrent.Future;

import com.danubetech.libsovrin.pool.Pool;
import com.danubetech.libsovrin.pool.Pool.OpenPoolLedgerResult;
import com.danubetech.libsovrin.pool.PoolImpl;

public class Example {

	public static void main(String[] args) throws Exception {

		if (! LibSovrin.isInitialized()) LibSovrin.init(new File("./lib/libsovrin.so"));

		Pool pool = new PoolImpl();
		Future<OpenPoolLedgerResult> result = pool.openPoolLedger("default", null);

		int poolHandle = result.get().getPoolHandle();
		System.out.println("pool handle: " + poolHandle);
	}
}
