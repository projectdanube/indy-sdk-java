package com.danubetech.libsovrin;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {

	Success(0),

	// Common errors
	// Caller passed invalid pool ledger handle
	CommonInvalidPoolLedgerHandle(100),

	// Caller passed invalid wallet handle
	CommonInvalidWalletHandle(101),

	// Caller passed invalid value as param 1 (null, invalid json and etc..)
	CommonInvalidParam1(102),

	// Caller passed invalid value as param 2 (null, invalid json and etc..)
	CommonInvalidParam2(103),

	// Caller passed invalid value as param 3 (null, invalid json and etc..)
	CommonInvalidParam3(104),

	// Caller passed invalid value as param 4 (null, invalid json and etc..)
	CommonInvalidParam4(105),

	// Caller passed invalid value as param 5 (null, invalid json and etc..)
	CommonInvalidParam5(106),

	// Invalid library state was detected in runtime. It signals library bug
	CommonInvalidState(107),

	// Wallet errors
	// Unknown type of wallet was passed on create_wallet
	WalletUnknownTypeError(200),

	// Attempt to register already existing wallet type
	WalletTypeAlreadyRegisteredError(201),

	// Requested entity id isn't present in wallet
	WalletNotFoundError(202),

	// Wallet files referenced in open_wallet have invalid data format
	WalletInvalidDataFormat(203),

	// IO error during access wallet backend
	WalletIOError(204),

	// Trying to use wallet with pool that has different name
	WalletIncompatiblePoolError(205),

	// Ledger errors
	// Pool ledger files referenced in open_pool_ledger have invalid data format
	PoolLedgerInvalidDataFormat(300),

	// IO error during access pool ledger files
	PoolILedgerOError(301),

	// No concensus during ledger operation
	LedgerNoConsensusError(302),

	// Attempt to send unknown or incomplete transaction message
	LedgerInvalidTransaction(303),

	// Attempt to send transaction without the necessary privileges
	LedgerSecurityError(304),

	// IO error during sending of ledger transactions or catchup process
	LedgerIOError(305),

	// Crypto errors
	// Invalid structure of any crypto promitives (keys, signatures, seeds and etc...)
	CryptoInvalidStructure(400),

	// Unknown crypto type was requested for signing/verifiyng or encoding/decoding
	CryptoUnknownTypeError(401),

	// Revocation registry is full and creation of new registry is necessary
	CryptoRevocationRegistryFullError(402),

	CryptoInvalidUserRevocIndex(403),

	CryptoBackendError(404),

	AnoncredsNotIssuedError(405),

	// Attempt to generate master secret with dupplicated name
	AnoncredsMasterSecretDuplicateNameError(406);

	private int value;
	private static Map<Integer, ErrorCode> map = new HashMap<> ();

	private ErrorCode(int value) {

		this.value = value;
	}

	static {

		for (ErrorCode errorCode : ErrorCode.values()) {

			map.put(Integer.valueOf(errorCode.value), errorCode);
		}
	}

	public static ErrorCode valueOf(int value) {

		return map.get(Integer.valueOf(value));
	}

	public int value() {

		return this.value;
	}
}
