package view;

import coordinator.BayCoordinator;
import coordinator.BayService;
import exception.BayNotExistException;
import factory.BayFactory;
import pojo.Bay;
import pojo.Vehicle;
import types.BayIndex;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
  private static Warehouse instance;

  private final BayService bayService;
  private final VehicleTerminal mainTerminal;

  private Warehouse() {
    List<Bay> bays = new ArrayList<>();

    this.bayService = new BayCoordinator(bays);
    this.mainTerminal = new VehicleTerminal();
  }

  public void initialize() throws BayNotExistException {
    List<Bay> bays = this.bayService.getAll();
    bays.add(BayFactory.create(BayIndex.BAY_A));
    bays.add(BayFactory.create(BayIndex.BAY_B));
    bays.add(BayFactory.create(BayIndex.BAY_C));
    bays.add(BayFactory.create(BayIndex.BAY_D));
    bays.add(BayFactory.create(BayIndex.BAY_E));
    bays.add(BayFactory.create("F"));

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
