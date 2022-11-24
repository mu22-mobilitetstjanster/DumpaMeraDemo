package exception;

public class BayNotExistException extends Exception {

  public BayNotExistException(String bayIndex) {
    super("Bay " + bayIndex + " does not yet exist");
  }
}
