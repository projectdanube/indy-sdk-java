package com.danubetech.libsovrin;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {

    Success(0),

    // Common errors

    // Caller passed invalid value as param 1 (null, invalid json and etc..)
    CommonInvalidParam1(100),

    // Caller passed invalid value as param 2 (null, invalid json and etc..)
    CommonInvalidParam2(101),

    // Caller passed invalid value as param 3 (null, invalid json and etc..)
    CommonInvalidParam3(102),

    // Caller passed invalid value as param 4 (null, invalid json and etc..)
    CommonInvalidParam4(103),

    // Caller passed invalid value as param 5 (null, invalid json and etc..)
    CommonInvalidParam5(104),

    // Caller passed invalid value as param 6 (null, invalid json and etc..)
    CommonInvalidParam6(105),

    // Caller passed invalid value as param 7 (null, invalid json and etc..)
    CommonInvalidParam7(106),

    // Caller passed invalid value as param 8 (null, invalid json and etc..)
    CommonInvalidParam8(107),

    // Caller passed invalid value as param 9 (null, invalid json and etc..)
    CommonInvalidParam9(108),

    // Invalid library state was detected in runtime. It signals library bug
    CommonInvalidState(109),

    // Wallet errors
    // Caller passed invalid wallet handle
    WalletInvalidHandle(200),

    // Unknown type of wallet was passed on create_wallet
    WalletUnknownTypeError(201),

    // Attempt to register already existing wallet type
    WalletTypeAlreadyRegisteredError(202),

    // Attempt to create wallet with name used for another exists wallet
    WalletAlreadyExistsError(203),

    // Requested entity id isn't present in wallet
    WalletNotFoundError(204),

    // Wallet files referenced in open_wallet have invalid data format
    WalletInvalidDataFormat(205),

    // IO error during access wallet backend
    WalletIOError(206),

    // Trying to use wallet with pool that has different name
    WalletIncompatiblePoolError(207),

    // Trying to open wallet with invalid configuration
    WalletInvalidConfiguration(208),

    // Error in wallet backend
    WalletBackendError(209),

    // Ledger errors
    // Trying to open pool ledger that wasn't created before
    PoolLedgerNotCreatedError(300),

    // Invalid pool ledger configuration was passed to open_pool_ledger or create_pool_ledger
    PoolLedgerInvalidConfiguration(301),

    // Pool ledger files referenced in open_pool_ledger have invalid data format
    PoolLedgerInvalidDataFormat(302),

    // Caller passed invalid pool ledger handle
    PoolLedgerInvalidPoolHandle(303),

    // IO error during access pool ledger files
    PoolLedgerIOError(304),

    // No concensus during ledger operation
    LedgerNoConsensusError(305),

    // Attempt to send unknown or incomplete transaction message
    LedgerInvalidTransaction(306),

    // Attempt to send transaction without the necessary privileges
    LedgerSecurityError(307),

    // IO error during sending of ledger transactions or catchup process
    LedgerIOError(308),

    // Crypto errors
    // Invalid structure of any crypto promitives (keys, signatures, seeds and etc...)
    CryptoInvalidStructure(400),

    // Unknown crypto type was requested for signing/verifiyng or encoding/decoding
    CryptoUnknownTypeError(401),

    // Revocation registry is full and creation of new registry is necessary
    CryptoRevocationRegistryFullError(402),

    CryptoInvalidUserRevocIndex(403),

    // Error in crypto backend
    CryptoBackendError(404),

    AnoncredsNotIssuedError(405),

    // Attempt to generate master secret with dupplicated name
    AnoncredsMasterSecretDuplicateNameError(406),

    ProofRejected(407);

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
