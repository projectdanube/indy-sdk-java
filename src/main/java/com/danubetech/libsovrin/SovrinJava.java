package com.danubetech.libsovrin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class SovrinJava {

	/*
	 * API
	 */

	public static class API {

		protected static final int FIXED_COMMAND_HANDLE = 0;

		protected static boolean checkCallback(CompletableFuture<? extends SovrinJava.Result> future, int xcommand_handle, int err) {

			assert(xcommand_handle == FIXED_COMMAND_HANDLE);

			ErrorCode errorCode = ErrorCode.valueOf(err);
			if (! ErrorCode.Success.equals(errorCode)) { future.completeExceptionally(SovrinException.fromErrorCode(errorCode)); return false; }

			return true;
		}

		protected static void checkResult(int result) throws SovrinException {

			ErrorCode errorCode = ErrorCode.valueOf(result);
			if (! ErrorCode.Success.equals(errorCode)) throw SovrinException.fromErrorCode(errorCode);
		}
	}

	/*
	 * JSON parameter
	 */

	public abstract static class JsonParameter {

		protected Map<String, Object> map = new HashMap<String, Object> ();

		public final String toJson() {

			StringBuilder builder = new StringBuilder();
			builder.append("{");

			for (Iterator<Map.Entry<String, Object>> iterator = this.map.entrySet().iterator(); iterator.hasNext(); ) {

				Map.Entry<String, Object> entry = iterator.next();
				String key = entry.getKey();
				Object value = entry.getValue();
				builder.append("\"" + key + "\":\"");
				builder.append(escapeJson(value.toString()));
				builder.append("\"");
				if (iterator.hasNext()) builder.append(",");
			}

			return builder.toString();
		}

		private static String escapeJson(String string) {

			return string.replace("\\", "\\\\").replace("\"", "\\\"");
		}
	}

	/*
	 * Result
	 */

	public interface Result {

	}
}