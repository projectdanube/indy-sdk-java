package com.danubetech.libsovrin.wallet;

import com.danubetech.libsovrin.SovrinJava;

/**
 * wallet.rs Results
 */
public final class WalletResults {

	private WalletResults() {

	}

	public static class CreateWalletResult implements SovrinJava.Result {

		CreateWalletResult() { }
	}

	public static class OpenWalletResult implements SovrinJava.Result {

		private Wallet wallet;
		OpenWalletResult(Wallet wallet) { this.wallet = wallet; }
		public Wallet getWallet() { return this.wallet; }
	}

	public static class CloseWalletResult implements SovrinJava.Result {

		CloseWalletResult() { }
	}

	public static class DeleteWalletResult implements SovrinJava.Result {

		DeleteWalletResult() { }
	}

	public static class WalletSetSeqNoForValueResult implements SovrinJava.Result {

		WalletSetSeqNoForValueResult() { }
	}
}
