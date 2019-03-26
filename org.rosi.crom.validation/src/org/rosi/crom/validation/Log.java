package org.rosi.crom.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class Log {
	
	private static void log(int status, String message) {
		Activator
		.getDefault()
		.getLog()
		.log(new Status(status, Activator.PLUGIN_ID, message));
	}

	public static void error(String message, Object... args) {
		log(IStatus.ERROR, String.format(message, args));
	}
	
	public static void info(String message, Object... args) {
		log(IStatus.INFO, String.format(message, args));
	}
	
	public static void warning(String message, Object... args) {
		log(IStatus.WARNING, String.format(message, args));
	}
	
	public static void ok(String message, Object... args) {
		log(IStatus.OK, String.format(message, args));
	}
}
