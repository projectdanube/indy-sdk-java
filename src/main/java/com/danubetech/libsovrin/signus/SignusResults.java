package com.danubetech.libsovrin.signus;

/**
 * signus.rs Results
 */
public final class SignusResults {

	private SignusResults() {

	}

	public static class CreateAndStoreMyDidResult {

		private String did, verkey, pk;
		CreateAndStoreMyDidResult(String did, String verkey, String pk) { this.did = did; this.verkey = verkey; this.pk = pk; }
		public String getDid() { return this.did; }
		public String getVerkey() { return this.verkey; }
		public String getPk() { return this.pk; }
	}

	public static class ReplaceKeysResult {

		private String verkey, pk;
		ReplaceKeysResult(String verkey, String pk) { this.verkey = verkey; this.pk = pk; }
		public String getVerkey() { return this.verkey; }
		public String getPk() { return this.pk; }
	}

	public static class StoreTheirDidResult {

		StoreTheirDidResult() { }
	}

	public static class SignResult {

		private String signature;
		SignResult(String signature) { this.signature = signature; }
		public String getSignature() { return this.signature; }
	}

	public static class VerifySignatureResult {

		private boolean valid;
		VerifySignatureResult(boolean valid) { this.valid = valid; }
		public boolean isValid() { return this.valid; }
	}

	public static class EncryptResult {

		private String encryptedMsg;
		EncryptResult(String encryptedMsg) { this.encryptedMsg = encryptedMsg; }
		public String getEncryptedMsg() { return this.encryptedMsg; }
	}

	public static class DecryptResult {

		private String decryptedMsg;
		DecryptResult(String decryptedMsg) { this.decryptedMsg = decryptedMsg; }
		public String getDecryptedMsg() { return this.decryptedMsg; }
	}
}
