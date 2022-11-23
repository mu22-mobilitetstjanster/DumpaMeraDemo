import view.Warehouse;

public class Application {

  public static void main(String[] args) {
    Warehouse
            .getInstance()
            .initialize();
  }
}
