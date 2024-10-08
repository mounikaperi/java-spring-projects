import java.util.*;

public class RethrowExceptions {
    public static void main(String[] args) throws Exception {
      beforeJava7("First");
      withJava7("First");
    }
    private static void beforeJava7(String exceptionName) throws Exception {
      try {
        if (exceptionName.equals("First")) {
          throw new FirstException();
        } else {
          throw new SecondException();
        }
      } catch (Exception ex) {
        throw ex;
      }
    }
    private static void withJava7(String exceptionName) throws FirstException, SecondException {
      try {
        if (exceptionName.equals("First")) {
          throw new FirstException();
        } else {
          throw new SecondException();
        }
      } catch (Exception ex) {
        throw ex;
      }
    }
    static class FirstException extends Exception {
      
    }
    static class SecondException extends Exception {
      
    }
}