package com.danubetech.sovrin.client;

public class Example {

	public static void main(String[] args) {

		SovrinClient client = new SovrinClientImpl("localhost:1234");

		try {

			int result = client.setDID("did:sov:21tDAKCERh95uGgKbJNHYp", "lji9qTtkCydxtez/bt1zdLxVMMbz4SzWvlqgOBmURoM=", null, null, "USER");
			System.out.println("setDID result: " + result);
		} finally {

			client.close();
		}
	}
}
