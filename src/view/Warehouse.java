package view;

import coordinator.BayCoordinator;
import coordinator.BayService;
import factory.BayFactory;
import pojo.Bay;
import pojo.Vehicle;
import types.BayIndex;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
  private static Warehouse instance;

  private final BayService bayService;
  private final TruckTerminal mainTerminal;

  private Warehouse() {
    List<Bay> bays = new ArrayList<>();
    bays.add(BayFactory.create(BayIndex.BAY_A));
    bays.add(BayFactory.create(BayIndex.BAY_B));
    bays.add(BayFactory.create(BayIndex.BAY_C));
    bays.add(BayFactory.create(BayIndex.BAY_D));
    bays.add(BayFactory.create(BayIndex.BAY_E));

    this.bayService = new BayCoordinator(bays);
    this.mainTerminal = new TruckTerminal();
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
