package com.ocp17.java7;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.InvocationTargetException;

public class ExceptionHandlingForReflectiveMethods {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
      beforeJava7();
      withJava7();
    }
    private static void beforeJava7() {
      try {
        Class.forName("com.ocp17.java7.CatchingMultipleExceptions").getMethod("withJava7").invoke(null, new Object[] {});
      } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException ex) {
        LOGGER.log(Level.SEVERE, ex.toString());
      }
    }
    private static void withJava7() {
      try {
			  Class.forName("com.ocp17.java7.CatchingMultipleExceptions").getMethod("withJava7").invoke(null, new Object[] {});
		  } catch (ReflectiveOperationException nex) {
			  LOGGER.log(Level.SEVERE, nex.toString());
		  }
    }
}