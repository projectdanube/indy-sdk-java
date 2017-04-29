package com.danubetech.libsovrin;

import java.util.concurrent.CompletableFuture;

public abstract class SovrinModule {

	public static final int FIXED_COMMAND_HANDLE = 0;

	protected boolean checkCallback(CompletableFuture<?> future, int xcommand_handle, int err) {

		assert(xcommand_handle == FIXED_COMMAND_HANDLE);

		ErrorCode errorCode = ErrorCode.valueOf(err);
		if (! ErrorCode.Success.equals(errorCode)) { future.completeExceptionally(SovrinException.fromErrorCode(errorCode)); return false; }

		return true;
	}

	protected void checkResult(int result) throws SovrinException {

		ErrorCode errorCode = ErrorCode.valueOf(result);
		if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);
	}
}