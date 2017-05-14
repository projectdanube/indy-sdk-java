package com.danubetech.libsovrin.anoncreds;

import com.danubetech.libsovrin.SovrinJava;

/**
 * anoncreds.rs Results
 */
public final class AnoncredsResults {

	private AnoncredsResults() {

	}

	public static class IssuerCreateAndStoreClaimDefResult implements SovrinJava.Result {

		private String claimDefJson, claimDefUuid;
		IssuerCreateAndStoreClaimDefResult(String claimDefJson, String claimDefUuid) { this.claimDefJson = claimDefJson; this.claimDefUuid = claimDefUuid; }
		public String getClaimDefJson() { return this.claimDefJson; }
		public String getClaimDefUuid() { return this.claimDefUuid; }
	}

	public static class IssuerCreateAndStoreRevocRegResult implements SovrinJava.Result {

		private String revocRegJson, revocRegUuid;
		IssuerCreateAndStoreRevocRegResult(String revocRegJson, String revocRegUuid) { this.revocRegJson = revocRegJson; this.revocRegUuid = revocRegUuid; }
		public String getRevocRegJson() { return this.revocRegJson; }
		public String getRevocRegUuid() { return this.revocRegUuid; }
	}

	public static class IssuerCreateClaimResult implements SovrinJava.Result {

		private String revocRegUpdateJson, claimJson;
		IssuerCreateClaimResult(String revocRegUpdateJson, String claimJson) { this.revocRegUpdateJson = revocRegUpdateJson; this.claimJson = claimJson; }
		public String getRevocRegUpdateJson() { return this.revocRegUpdateJson; }
		public String getClaimJson() { return this.claimJson; }
	}

	public static class IssuerRevokeClaimResult implements SovrinJava.Result {

		private String revocRegUpdateJson;
		IssuerRevokeClaimResult(String revocRegUpdateJson) { this.revocRegUpdateJson = revocRegUpdateJson; }
		public String getRevocRegUpdateJson() { return this.revocRegUpdateJson; }
	}

	public static class ProverStoreClaimOfferResult implements SovrinJava.Result {

		ProverStoreClaimOfferResult() { }
	}

	public static class ProverGetClaimsOffersResult implements SovrinJava.Result {

		private String claimsOffersJson;
		ProverGetClaimsOffersResult(String claimsOffersJson) { this.claimsOffersJson = claimsOffersJson; }
		public String getClaimsOffersJson() { return this.claimsOffersJson; }
	}

	public static class ProverCreateMasterSecretResult implements SovrinJava.Result {

		ProverCreateMasterSecretResult() { }
	}

	public static class ProverCreateAndStoreClaimReqResult implements SovrinJava.Result {

		private String claimReqJson;
		ProverCreateAndStoreClaimReqResult(String claimReqJson) { this.claimReqJson = claimReqJson; }
		public String getClaimReqJson() { return this.claimReqJson; }
	}

	public static class ProverStoreClaimResult implements SovrinJava.Result {

		ProverStoreClaimResult() { }
	}

	public static class ProverGetClaimsResult implements SovrinJava.Result {

		private String claimsJson;
		ProverGetClaimsResult(String claimsJson) { this.claimsJson = claimsJson; }
		public String getClaimsJson() { return this.claimsJson; }
	}

	public static class ProverGetClaimsForProofReqResult implements SovrinJava.Result {

		private String claimsJson;
		ProverGetClaimsForProofReqResult(String claimsJson) { this.claimsJson = claimsJson; }
		public String getClaimsJson() { return this.claimsJson; }
	}

	public static class ProverCreateProofResult implements SovrinJava.Result {

		private String proofJson;
		ProverCreateProofResult(String proofJson) { this.proofJson = proofJson; }
		public String getProofJson() { return this.proofJson; }
	}

	public static class VerifierVerifyProofResult implements SovrinJava.Result {

		private boolean valid;
		VerifierVerifyProofResult(boolean valid) { this.valid = valid; }
		public boolean isValid() { return this.valid; }
	}
}
