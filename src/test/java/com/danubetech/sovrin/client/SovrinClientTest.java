package com.danubetech.sovrin.client;

import java.io.File;

import junit.framework.TestCase;

public class SovrinClientTest extends TestCase {

	private SovrinClient client;

	@Override
	protected void setUp() throws Exception {

		NativeSovrinClient.init(new File("./l/libsovclient.so"));
		
		client = new SovrinClientImpl("localhost:1234");
	}

	@Override
	protected void tearDown() throws Exception {

		client.close();
	}

	public void testSetDid() {

		int result = client.setDid("dest", "verKey", "xref", "data", "role");
		assertEquals(result, 0);
	}
}
