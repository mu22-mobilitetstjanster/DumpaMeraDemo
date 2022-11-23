package pojo;

import java.util.List;

public class Bay {
  private String index;
  private int weightRestriction;
  private List<Integer> vehicleRestrictions;

  private Vehicle vehicle;


  public Bay(String index, int weightRestriction, List<Integer> vehicleRestrictions) {
    this.index = index;
    this.weightRestriction = weightRestriction;
    this.vehicleRestrictions = vehicleRestrictions;
  }

  public String getIndex() {
    return index;
  }

  public List<Integer> getVehicleRestrictions() {
    return vehicleRestrictions;
  }

  public int getWeightRestriction() {
    return weightRestriction;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }


  @Override
  public String toString() {
    if(vehicle == null) {
      return "Bay{" +
              "index='" + index + '\'' +
              ", state=empty" +
              '}';
    } else {
      return "Bay{" +
              "index='" + index + '\'' +
              ", vehicleType=" + vehicle.getType() + '\'' +
              ", vehicleWeight=" + vehicle.getWeight() +
              '}';
    }
  }
}
