package com.ocp17.java7;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ocp17.java7.utils.CustomDirtyResource;

public class SuppressedExceptions {

	private final static Logger LOGGER = Logger.getLogger(SuppressedExceptions.class.getName());
	
	public static void main(String[] args) {
		try {
			beforeJava7();
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, ex.getMessage());
		}
		try {
			withJava7();
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, ex.getMessage());
			final Throwable[] suppressedExceptions = ex.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if (numSuppressed > 0) {
				for (final Throwable exception: suppressedExceptions) {
					LOGGER.log(Level.SEVERE, exception.getMessage());
				}
			}
		}
	}
	private static void beforeJava7() throws Exception {
		CustomDirtyResource cr = null;
		try {
			cr = new CustomDirtyResource();
			cr.readFromResource();
		} catch (Exception ex) {
			cr.close();
		}
	}
	private static void withJava7() throws Exception {
		try (CustomDirtyResource cr = new CustomDirtyResource();) {
			cr.readFromResource();
		}
	}
}
