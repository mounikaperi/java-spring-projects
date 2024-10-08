import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchingMultipleExceptions {
    private final static Logger LOGGER = Logger.getLogger(CatchingMultipleExceptions.class.getName());
    public static void main(String[] args) {
      beforeJava7();
      withJava7();
    }
    private static void beforeJava7() {
      int[] arr = {1, 2, 3};
      try {
        for (int value: arr) {
          System.out.print(value + " ");
        }
        System.out.println();
      } catch (NullPointerException ex) {
        LOGGER.log(Level.SEVERE, ex.toString());
      } catch (ArrayIndexOutOfBoundsException ex) {
        LOGGER.log(Level.SEVERE, ex.toString());
      }
    }
    private static void withJava7() {
      int[] arr = null;
      try {
        for (int value: arr) {
          System.out.print(value + " ");
        }
        System.out.println();
      } catch (NullPointerException | ArrayIndexOutOfBoundsException | ClassCastException ex) {
        LOGGER.log(Level.SEVERE, ex.toString());
      }
    }
}