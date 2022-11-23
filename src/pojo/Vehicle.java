package pojo;

public abstract class Vehicle {
  private int type;
  private int weight;

  public Vehicle(int type, int weight) {
    this.type = type;
    this.weight = weight;
  }

  public int getType() {
    return type;
  }

  public int getWeight() {
    return weight;
  }
}
