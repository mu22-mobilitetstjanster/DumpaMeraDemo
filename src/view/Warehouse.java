package view;

import coordinator.BayCoordinator;
import coordinator.BayService;
import pojo.Bay;
import pojo.Vehicle;
import types.BayIndex;
import types.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
  private static Warehouse instance;

  private final BayService bayService;
  private final MainTerminal mainTerminal;

  private Warehouse() {
    List<Integer> vehicleRestrictionsBayA = List.of(VehicleType.VAN, VehicleType.LIGHT_TRUCK);
    List<Integer> vehicleRestrictionsBayB = List.of(VehicleType.VAN);
    List<Integer> vehicleRestrictionsBayC = List.of(VehicleType.LIGHT_TRUCK);
    List<Integer> vehicleRestrictionsBayD = List.of(VehicleType.LIGHT_TRUCK, VehicleType.HEAVY_TRUCK);
    List<Integer> vehicleRestrictionsBayE = List.of(VehicleType.HEAVY_TRUCK);

    List<Bay> bays = new ArrayList<>();
    bays.add(new Bay(BayIndex.BAY_A, 5000, vehicleRestrictionsBayA));
    bays.add(new Bay(BayIndex.BAY_B, 5000, vehicleRestrictionsBayB));
    bays.add(new Bay(BayIndex.BAY_C, 9000, vehicleRestrictionsBayC));
    bays.add(new Bay(BayIndex.BAY_D, 9000, vehicleRestrictionsBayD));
    bays.add(new Bay(BayIndex.BAY_E, 15000, vehicleRestrictionsBayE));

    this.bayService = new BayCoordinator(bays);
    this.mainTerminal = new MainTerminal();
  }

  public void initialize() {
    mainTerminal.initialize();
    mainTerminal.viewOptions();
  }

  public void viewBays() {
    List<Bay> bays = this.bayService.getAll();
    bays.forEach(System.out::println);
  }

  public void registerNewVehicle(Vehicle vehicle) {
    Bay bay = this.bayService.add(vehicle);

    if(bay == null) {
      System.out.println("Failed to find a suitable bay");
    } else {
      System.out.println("Vehicle added to bay " + bay.getIndex());
    }
  }

  public static Warehouse getInstance() {
    if(instance == null) {
      instance = new Warehouse();
    }
    return instance;
  }
}
