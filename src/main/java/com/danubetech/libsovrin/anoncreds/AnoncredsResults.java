package com.danubetech.libsovrin.anoncreds;

/**
 * anoncreds.rs Results
 */
public final class AnoncredsResults {

	private AnoncredsResults() {

	}

	public static class IssuerCreateAndStoreClaimDefResult {

		private String claimDefJson, claimDefUuid;
		IssuerCreateAndStoreClaimDefResult(String claimDefJson, String claimDefUuid) { this.claimDefJson = claimDefJson; this.claimDefUuid = claimDefUuid; }
		public String getClaimDefJson() { return this.claimDefJson; }
		public String getClaimDefUuid() { return this.claimDefUuid; }
	}

	public static class IssuerCreateAndStoreRevocRegResult {

		private String revocRegJson, revocRegUuid;
		IssuerCreateAndStoreRevocRegResult(String revocRegJson, String revocRegUuid) { this.revocRegJson = revocRegJson; this.revocRegUuid = revocRegUuid; }
		public String getRevocRegJson() { return this.revocRegJson; }
		public String getRevocRegUuid() { return this.revocRegUuid; }
	}

	public static class IssuerCreateClaimResult {

		private String revocRegUpdateJson, claimJson;
		IssuerCreateClaimResult(String revocRegUpdateJson, String claimJson) { this.revocRegUpdateJson = revocRegUpdateJson; this.claimJson = claimJson; }
		public String getRevocRegUpdateJson() { return this.revocRegUpdateJson; }
		public String getClaimJson() { return this.claimJson; }
	}

	public static class IssuerRevokeClaimResult {

		private String revocRegUpdateJson;
		IssuerRevokeClaimResult(String revocRegUpdateJson) { this.revocRegUpdateJson = revocRegUpdateJson; }
		public String getRevocRegUpdateJson() { return this.revocRegUpdateJson; }
	}

	public static class ProverStoreClaimOfferResult {

		ProverStoreClaimOfferResult() { }
	}

	public static class ProverGetClaimsOffersResult {

		private String claimsOffersJson;
		ProverGetClaimsOffersResult(String claimsOffersJson) { this.claimsOffersJson = claimsOffersJson; }
		public String getClaimsOffersJson() { return this.claimsOffersJson; }
	}

	public static class ProverCreateMasterSecretResult {

		ProverCreateMasterSecretResult() { }
	}

	public static class ProverCreateAndStoreClaimReqResult {

		private String claimReqJson;
		ProverCreateAndStoreClaimReqResult(String claimReqJson) { this.claimReqJson = claimReqJson; }
		public String getClaimReqJson() { return this.claimReqJson; }
	}

	public static class ProverStoreClaimResult {

		ProverStoreClaimResult() { }
	}

	public static class ProverGetClaimsResult {

		private String claimsJson;
		ProverGetClaimsResult(String claimsJson) { this.claimsJson = claimsJson; }
		public String getClaimsJson() { return this.claimsJson; }
	}

	public static class ProverGetClaimsForProofReqResult {

		private String claimsJson;
		ProverGetClaimsForProofReqResult(String claimsJson) { this.claimsJson = claimsJson; }
		public String getClaimsJson() { return this.claimsJson; }
	}

	public static class ProverCreateProofResult {

		private String proofJson;
		ProverCreateProofResult(String proofJson) { this.proofJson = proofJson; }
		public String getProofJson() { return this.proofJson; }
	}

	public static class VerifierVerifyProofResult {

		private boolean valid;
		VerifierVerifyProofResult(boolean valid) { this.valid = valid; }
		public boolean isValid() { return this.valid; }
	}
}
