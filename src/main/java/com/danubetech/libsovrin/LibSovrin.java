package com.danubetech.libsovrin;

import java.io.File;

import com.kenai.jffi.CallingConvention;
import com.kenai.jffi.Closure;
import com.kenai.jffi.ClosureManager;
import com.kenai.jffi.Type;

import jnr.ffi.Address;
import jnr.ffi.LibraryLoader;

public abstract class LibSovrin {

	public static final String LIBRARY_NAME = "sovrin";

	/*
	 * Native library interface
	 */

	public interface API {

		// pool.rs

		public int sovrin_create_pool_ledger_config(int command_handle, String config_name, String config, Address cb);
		public int sovrin_open_pool_ledger(int command_handle, String config_name, String config, Address cb);
		public int sovrin_refresh_pool_ledger(int command_handle, int handle, Address cb);
		public int sovrin_close_pool_ledger(int command_handle, int handle, Address cb);
		public int sovrin_delete_pool_ledger_config(int command_handle, String config_name, Address cb);

		// ledger.rs

		public int sign_and_submit_request(int command_handle, int wallet_handle, String submitter_did, String request_json, Address cb);
		public int submit_request(int command_handle, int pool_handle, String request_json, Address cb);
		public int build_get_ddo_request(int command_handle, String submitter_did, String target_did, String verkey, String xref, String data, String role, Address cb);
		public int build_nym_request(int command_handle, String submitter_did, String target_did, Address cb);
		public int build_attrib_request(int command_handle, String submitter_did, String target_did, String hash, String raw, String enc, Address cb);
		public int build_get_attrib_request(int command_handle, String submitter_did, String target_did, String data, Address cb);
		public int build_get_nym_request(int command_handle, String submitter_did, String target_did, Address cb);
		public int build_schema_request(int command_handle, String submitter_did, String data, Address cb);
		public int build_get_schema_request(int command_handle, String submitter_did, String data, Address cb);
		public int build_claim_def_txn(int command_handle, String submitter_did, String xref, String data, Address cb);
		public int build_get_claim_def_txn(int command_handle, String submitter_did, String xref, Address cb);
		public int build_node_request(int command_handle, String submitter_did, String target_did, String data, Address cb);

	}

	public static API api = null;

	/*
	 * Closures
	 */

	private abstract static class sovrin_Closure implements Closure {

		private Type[] parameterTypes;

		private sovrin_Closure(Type[] parameterTypes) { this.parameterTypes = parameterTypes; }
		public final Closure.Handle handle() { return ClosureManager.getInstance().newClosure(this, Type.VOID, parameterTypes, CallingConvention.DEFAULT); }
		public final Address address() { return Address.valueOf(this.handle().getAddress()); }

/*
 * 		WE COULD PROBABLY REDUCE CODE BY AUTOMATICALLY CALLING AN invoke() METHOD
 * 		THROUGH REFLECTION HERE, BUT THIS MAY TAKE A PERFORMANCE HIT WITH
 * 		JAVA's AUTOBOXING OF PRIMITIVE VALUES
 * 
 * 
 * 		public final void invoke(Buffer buffer) { 

			Class<?>[] javaParameterTypes = new Class<?>[cParameterTypes.length];
			Object[] javaParameterValues = new Class<?>[cParameterTypes.length];
			
			for (int i=0; i<javaParameterTypes.length; i++) {
				
				Type cParameterType = this.cParameterTypes[i];
				Class<?> javaParameterType;
				if (cParameterType.equals(Type.SINT32)) { javaParameterTypes[i] = int.class; javaParameterValues[i]
			}
			
			try {

				Method invokeMethod = this.getClass().getMethod("invoke", javaParameterTypes);
				invokeMethod.in
			} catch (NoSuchMethodException | SecurityException ex) {
				
				throw new RuntimeException("Cannot invoke method on class " + this.getClass().getName() + ": " + ex.getMessage(), ex);
			}
		}*/
	}

	// pool.rs

	public abstract static class sovrin_create_pool_ledger_config_Closure extends sovrin_Closure {

		public sovrin_create_pool_ledger_config_Closure() { super( new Type[] { Type.SINT32, Type.SINT32 }); }
		public final void invoke(Buffer buffer) { invoke(buffer.getInt(0), buffer.getInt(1)); }
		public abstract void invoke(int xcommand_handle, int err);
	}

	public abstract static class sovrin_open_pool_ledger_Closure extends sovrin_Closure {

		public sovrin_open_pool_ledger_Closure() { super(new Type[] { Type.SINT32, Type.SINT32, Type.SINT32 }); }
		public final void invoke(Buffer buffer) { invoke(buffer.getInt(0), buffer.getInt(1), buffer.getInt(2)); }
		public abstract void invoke(int xcommand_handle, int err, int pool_handle);
	}

	public abstract static class sovrin_refresh_pool_ledger_Closure extends sovrin_Closure {

		public sovrin_refresh_pool_ledger_Closure() { super(new Type[] { Type.SINT32, Type.SINT32 }); }
		public final void invoke(Buffer buffer) { invoke(buffer.getInt(0), buffer.getInt(1)); }
		public abstract void invoke(int xcommand_handle, int err);
	}

	public abstract static class sovrin_close_pool_ledger_Closure extends sovrin_Closure {

		public sovrin_close_pool_ledger_Closure() { super(new Type[] { Type.SINT32, Type.SINT32 }); }
		public final void invoke(Buffer buffer) { invoke(buffer.getInt(0), buffer.getInt(1)); }
		public abstract void invoke(int xcommand_handle, int err);
	}

	public abstract static class sovrin_delete_pool_ledger_config_Closure extends sovrin_Closure {

		public sovrin_delete_pool_ledger_config_Closure() { super(new Type[] { Type.SINT32, Type.SINT32 }); }
		public final void invoke(Buffer buffer) { invoke(buffer.getInt(0), buffer.getInt(1)); }
		public abstract void invoke(int xcommand_handle, int err);
	}

	/*
	 * Initialization
	 */

	static {

		init();
	}

	public static void init(File file) {

		api = LibraryLoader.create(API.class).load(file.getAbsolutePath());
	}

	public static void init() {

		api = LibraryLoader.create(API.class)
				.search("lib")
				.load(LIBRARY_NAME);
	}

	public static boolean isInitialized() {

		return api != null;
	}
}
