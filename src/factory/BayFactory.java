package factory;

import exception.BayNotExistException;
import pojo.Bay;
import types.VehicleType;
import types.BayIndex;

import java.util.List;

public class BayFactory {

  public static Bay create(String bayIndex) {
    Bay bay = null;

    switch(bayIndex) {
      case BayIndex.BAY_A -> {
        List<Integer> vehicleRestrictions = List.of(VehicleType.VAN, VehicleType.LIGHT_TRUCK);
        bay = new Bay(BayIndex.BAY_A, 5000, vehicleRestrictions);
      }
      case BayIndex.BAY_B -> {
        List<Integer> vehicleRestrictions = List.of(VehicleType.VAN);
        bay = new Bay(BayIndex.BAY_B, 5000, vehicleRestrictions);
      }
      case BayIndex.BAY_C -> {
        List<Integer> vehicleRestrictions = List.of(VehicleType.LIGHT_TRUCK);
        bay = new Bay(BayIndex.BAY_C, 9000, vehicleRestrictions);
      }
      case BayIndex.BAY_D -> {
        List<Integer> vehicleRestrictions = List.of(VehicleType.LIGHT_TRUCK, VehicleType.HEAVY_TRUCK);
        bay = new Bay(BayIndex.BAY_D, 9000, vehicleRestrictions);
      }
      case BayIndex.BAY_E -> {
        List<Integer> vehicleRestrictions = List.of(VehicleType.HEAVY_TRUCK);
        bay = new Bay(BayIndex.BAY_E, 25000, vehicleRestrictions);
      }
      default -> throw new BayNotExistException(bayIndex);
    }

    return bay;
  }
}
