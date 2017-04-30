package com.danubetech.libsovrin.ledger;

import java.util.concurrent.Future;

import com.danubetech.libsovrin.SovrinException;

public interface Ledger {

	/*
	 * Methods
	 */

	public Future<SignAndSubmitRequestResult> signAndSubmitRequest(
			int walletHandle,
			String submitterDid,
			String requestJson) throws SovrinException;

	public Future<SubmitRequestResult> submitRequest(
			int poolHandle,
			String requestJson) throws SovrinException;

	public Future<BuildGetDdoRequestResult> buildGetDdoRequest(
			String submitterDid,
			String targetDid,
			String requestJson) throws SovrinException;

	public Future<BuildNymRequestResult> buildNymRequest(
			String submitterDid,
			String targetDid,
			String verkey,
			String xref,
			String data,
			String role) throws SovrinException;

	public Future<BuildAttribRequestResult> buildAttribRequest(
			String submitterDid,
			String targetDid,
			String hash,
			String raw,
			String enc) throws SovrinException;

	public Future<BuildGetAttribRequestResult> buildGetAttribRequest(
			String submitterDid,
			String targetDid,
			String data) throws SovrinException;

	public Future<BuildGetNymRequestResult> buildGetNymRequest(
			String submitterDid,
			String targetDid) throws SovrinException;

	public Future<BuildSchemaRequestResult> buildSchemaRequest(
			String submitterDid,
			String data) throws SovrinException;

	public Future<BuildGetSchemaRequestResult> buildGetSchemaRequest(
			String submitterDid,
			String data) throws SovrinException;

	public Future<BuildClaimDefTxnResult> buildClaimDefTxn(
			String submitterDid,
			String xref,
			String data) throws SovrinException;

	public Future<BuildGetClaimDefTxnResult> buildGetClaimDefTxn(
			String submitterDid,
			String xref) throws SovrinException;

	public Future<BuildNodeRequestResult> buildNodeRequest(
			String submitterDid,
			String targetDid,
			String data) throws SovrinException;

	/*
	 * Options
	 */

	/*
	 * Results
	 */

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

	public static class DeletePoolLedgerConfigResult {

		DeletePoolLedgerConfigResult() { }
	}
}
