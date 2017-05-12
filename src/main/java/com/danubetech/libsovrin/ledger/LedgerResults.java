package com.danubetech.libsovrin.ledger;

/**
 * ledger.rs Results
 */
public final class LedgerResults {

	private LedgerResults() {

	}

	public static class SignAndSubmitRequestResult {

		private String requestResultJson;
		SignAndSubmitRequestResult(String requestResultJson) { this.requestResultJson = requestResultJson; }
		public String getRequestResultJson() { return this.requestResultJson; }
	}

	public static class SubmitRequestResult {

		private String requestResultJson;
		SubmitRequestResult(String requestResultJson) { this.requestResultJson = requestResultJson; }
		public String getRequestResultJson() { return this.requestResultJson; }
	}

	public static class BuildGetDdoRequestResult {

		private String requestJson;
		BuildGetDdoRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildNymRequestResult {

		private String requestJson;
		BuildNymRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildAttribRequestResult {

		private String requestJson;
		BuildAttribRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildGetAttribRequestResult {

		private String requestJson;
		BuildGetAttribRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildGetNymRequestResult {

		private String requestJson;
		BuildGetNymRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildSchemaRequestResult {

		private String requestJson;
		BuildSchemaRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildGetSchemaRequestResult {

		private String requestJson;
		BuildGetSchemaRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildClaimDefTxnResult {

		private String requestJson;
		BuildClaimDefTxnResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}

	public static class BuildGetClaimDefTxnResult {

		private String requestResultJson;
		BuildGetClaimDefTxnResult(String requestResultJson) { this.requestResultJson = requestResultJson; }
		public String getRequestResultJson() { return this.requestResultJson; }
	}

	public static class BuildNodeRequestResult {

		private String requestJson;
		BuildNodeRequestResult(String requestJson) { this.requestJson = requestJson; }
		public String getRequestJson() { return this.requestJson; }
	}
}
