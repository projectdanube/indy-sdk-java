package com.danubetech.libsovrin.wallet;

import java.util.concurrent.Future;

import com.danubetech.libsovrin.SovrinException;

public interface Wallet {

/* IMPLEMENT LATER
 * public Future<...> registerWalletType(
			...) throws SovrinException;*/

	public Future<CreateWalletResult> createWallet(
			String poolName,
			String name,
			String xtype,
			String config,
			String credentials) throws SovrinException;

	public Future<OpenWalletResult> openWallet(
			int poolHandle,
			String name,
			String config,
			String credentials) throws SovrinException;

	public Future<CloseWalletResult> closeWallet(
			int handle) throws SovrinException;

	public Future<DeleteWalletResult> deleteWallet(
			String name) throws SovrinException;

	public Future<WalletSetSeqNoForValueResult> walletSetSeqNoForValue(
			int walletHandle,
			String walletKey,
			String configName) throws SovrinException;

	public static class CreateWalletResult {

		CreateWalletResult() { }
	}

	public static class OpenWalletResult {

		private int handle;
		OpenWalletResult(int handle) { this.handle = handle; }
		public int getHandle() { return this.handle; }
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
