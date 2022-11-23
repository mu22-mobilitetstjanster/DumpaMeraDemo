package factory;

import pojo.HeavyTruck;
import pojo.LightTruck;
import pojo.Van;
import pojo.Vehicle;
import types.VehicleType;

public class VehicleFactory {

  public static Vehicle create(int vehicleType, int vehicleWeight) {
    return switch(vehicleType) {
      case VehicleType.VAN -> new Van(vehicleWeight);
      case VehicleType.LIGHT_TRUCK -> new LightTruck(vehicleWeight);
      case VehicleType.HEAVY_TRUCK -> new HeavyTruck(vehicleWeight);
      default -> throw new IllegalStateException("Unable to identify type");
    };
  }
}
