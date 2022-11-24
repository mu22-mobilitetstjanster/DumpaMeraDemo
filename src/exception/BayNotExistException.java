package exception;

// Exception - checked (den hanteras try-catch
// RuntimeException - unchecked (den ger inga kompileringsfel)
public class BayNotExistException extends Exception {

  public BayNotExistException(String bayIndex) {
    super("Bay " + bayIndex + " does not yet exist");
  }
}
