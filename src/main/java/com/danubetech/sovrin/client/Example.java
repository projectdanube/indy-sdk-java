package com.danubetech.sovrin.client;

public class Example {

	public static void main(String[] args) {

		SovrinClient client = new SovrinClientImpl("localhost:1234");

		try {

			int result = client.setDid("dest", "verKey", "xref", "data", "role");
			System.out.println("setDid result: " + result);
		} finally {

			client.close();
		}
	}
}
