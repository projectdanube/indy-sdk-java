package com.danubetech.libsovrin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class SovrinJsonOptions {

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
