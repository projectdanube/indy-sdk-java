package com.danubetech.libsovrin.wallet;

/**
 * wallet.rs Results
 */
public final class WalletResults {

	private WalletResults() {

	}

	public static class CreateWalletResult {

		CreateWalletResult() { }
	}

	public static class OpenWalletResult {

		private Wallet wallet;
		OpenWalletResult(Wallet wallet) { this.wallet = wallet; }
		public Wallet getWallet() { return this.wallet; }
	}

	public static class CloseWalletResult {

		CloseWalletResult() { }
	}

	public static class DeleteWalletResult {

		DeleteWalletResult() { }
	}

	public static class WalletSetSeqNoForValueResult {

		WalletSetSeqNoForValueResult() { }
	}
}
