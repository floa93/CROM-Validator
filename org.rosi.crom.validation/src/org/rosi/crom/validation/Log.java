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

	public static void error(String message) {
		log(IStatus.ERROR, message);
	}
	
	public static void info(String message) {
		log(IStatus.INFO, message);
	}
	
	public static void warning(String message) {
		log(IStatus.WARNING, message);
	}
	
	public static void ok(String message) {
		log(IStatus.OK, message);
	}
}
