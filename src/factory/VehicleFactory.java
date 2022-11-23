package factory;

import pojo.HeavyTruck;
import pojo.LightTruck;
import pojo.Van;
import pojo.Vehicle;
import types.VehicleType;

public class VehicleFactory {

  public static Vehicle create(int vehicleType, int vehicleWeight) {
    Vehicle vehicle = null;

    if(vehicleType == VehicleType.VAN) {
      vehicle = new Van(vehicleWeight);
    } else if (vehicleType == VehicleType.LIGHT_TRUCK) {
      vehicle = new LightTruck(vehicleWeight);
    } else if (vehicleType == VehicleType.HEAVY_TRUCK) {
      vehicle = new HeavyTruck(vehicleWeight);
    } else {
      System.out.println("Could not identify vehicle type");
    }

    return vehicle;
  }
}
