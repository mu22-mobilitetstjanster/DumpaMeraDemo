package pojo;

public class Choice {
  private String title;
  private int index;

  public Choice(int index, String title) {
    this.title = title;
    this.index = index;
  }

  public String getTitle() {
    return title;
  }

  public int getIndex() {
    return index;
  }
}
