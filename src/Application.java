import exception.BayNotExistException;
import view.Warehouse;

public class Application {

  public static void main(String[] args) {
    try {
      Warehouse
              .getInstance()
              .initialize();
    } catch (BayNotExistException e) {
      e.printStackTrace();
    }
  }
}
