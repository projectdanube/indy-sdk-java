package com.danubetech.libsovrin.ledger;

import com.danubetech.libsovrin.SovrinJava;

/**
 * ledger.rs Results
 */
public final class LedgerResults {

	private LedgerResults() {

	}

	public static class SignAndSubmitRequestResult implements SovrinJava.Result {

		private String requestResultJson;
		SignAndSubmitRequestResult(String requestResultJson) { this.requestResultJson = requestResultJson; }
		public String getRequestResultJson() { return this.requestResultJson; }
	}

	public static class SubmitRequestResult implements SovrinJava.Result {

		private String requestResultJson;
		SubmitRequestResult(String requestResultJson) { this.requestResultJson = requestResultJson; }
		public String getRequestResultJson() { return this.requestResultJson; }
	}

	public static class BuildGetDdoRequestResult implements SovrinJava.Result {

		private String requestJson;
		BuildGetDdoRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildNymRequestResult implements SovrinJava.Result {

		private String requestJson;
		BuildNymRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildAttribRequestResult implements SovrinJava.Result {

		private String requestJson;
		BuildAttribRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildGetAttribRequestResult implements SovrinJava.Result {

		private String requestJson;
		BuildGetAttribRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildGetNymRequestResult implements SovrinJava.Result {

		private String requestJson;
		BuildGetNymRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildSchemaRequestResult implements SovrinJava.Result {

		private String requestJson;
		BuildSchemaRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildGetSchemaRequestResult implements SovrinJava.Result {

		private String requestJson;
		BuildGetSchemaRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildClaimDefTxnResult implements SovrinJava.Result {

		private String requestJson;
		BuildClaimDefTxnResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildGetClaimDefTxnResult implements SovrinJava.Result {

		private String requestResultJson;
		BuildGetClaimDefTxnResult(String requestResultJson) { this.requestResultJson = requestResultJson; }
		public String getRequestResultJson() { return this.requestResultJson; }
	}

	public static class BuildNodeRequestResult implements SovrinJava.Result {

		private String requestJson;
		BuildNodeRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}
}
