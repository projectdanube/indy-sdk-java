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
		public int sovrin_refresh_pool_ledger(int command_handle, String handle, Address cb);
		public int sovrin_close_pool_ledger(int command_handle, String handle, Address cb);
		public int sovrin_delete_pool_ledger_config(int command_handle, String config_name, Address cb);
	}

	public static API api = null;

	/*
	 * Closures and futures
	 */

	// pool.rs

	public abstract static class sovrin_create_pool_ledger_config_Closure implements Closure {

		public final void invoke(Buffer buffer) { invoke(buffer.getInt(0), buffer.getInt(1)); }
		public abstract void invoke(int xcommand_handle, int err);
		public final Closure.Handle handle() { return ClosureManager.getInstance().newClosure(this, Type.VOID, new Type[] { Type.SINT32, Type.SINT32 }, CallingConvention.DEFAULT); }
	}

	public abstract static class sovrin_open_pool_ledger_Closure implements Closure {

		public final void invoke(Buffer buffer) { invoke(buffer.getInt(0), buffer.getInt(1), buffer.getInt(2)); }
		public abstract void invoke(int xcommand_handle, int err, int pool_handle);
		public final Closure.Handle handle() { return ClosureManager.getInstance().newClosure(this, Type.VOID, new Type[] { Type.SINT32, Type.SINT32, Type.SINT32 }, CallingConvention.DEFAULT); }
	}

	public abstract static class sovrin_refresh_pool_ledger_Closure implements Closure {

		public final void invoke(Buffer buffer) { invoke(buffer.getInt(0), buffer.getInt(1)); }
		public abstract void invoke(int xcommand_handle, int err);
	}

	public abstract static class sovrin_close_pool_ledger_Closure implements Closure {

		public final void invoke(Buffer buffer) { invoke(buffer.getInt(0), buffer.getInt(1)); }
		public abstract void invoke(int xcommand_handle, int err);
	}

	public abstract static class sovrin_delete_pool_ledger_config_Closure implements Closure {

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
