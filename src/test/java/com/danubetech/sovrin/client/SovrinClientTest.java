package com.danubetech.sovrin.client;

import java.io.File;

import junit.framework.TestCase;

public class SovrinClientTest extends TestCase {

	private SovrinClient client;

	@Override
	protected void setUp() throws Exception {

		NativeSovrinClient.init(new File("./lib/libsovclient.so"));

		client = new SovrinClientImpl("localhost:1234");
	}

	@Override
	protected void tearDown() throws Exception {

		client.close();
	}

	public void testSetDID() {

		int result = client.setDID("did:sov:21tDAKCERh95uGgKbJNHYp", "lji9qTtkCydxtez/bt1zdLxVMMbz4SzWvlqgOBmURoM=", null, null, "USER");
		assertEquals(result, 0);
	}

	public void testGetVerKey() {

		String result = client.getVerKey("did:sov:21tDAKCERh95uGgKbJNHYp");
		assertEquals(result, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCABMC");
	}

	public void testGetDDO() {

		String result = client.getDDO("did:sov:21tDAKCERh95uGgKbJNHYp");
		assertTrue(result.length() > 100);
	}

	public void testSetAttr() {

		int result = client.setAttr("did:sov:21tDAKCERh95uGgKbJNHYp", null, null, null);
		assertEquals(result, 0);
	}

	public void testGetAttr() {

		String result = client.getAttr("did:sov:21tDAKCERh95uGgKbJNHYp", "attrname");
		assertEquals(result, "attrval");
	}

	public void testSetSchema() {

		int result = client.setSchema("schema");
		assertEquals(result, 0);
	}

	public void testGetSchema() {

		String result = client.getSchema();
		assertEquals(result, "schema");
	}

	public void testSetIssuerKey() {

		int result = client.setIssuerKey(null);
		assertEquals(result, 0);
	}

	public void testGetIssuerKey() {

		String result = client.getIssuerKey();
		assertEquals(result, "issuerkey");
	}
}
