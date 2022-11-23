package view;

import pojo.HeavyTruck;
import pojo.LightTruck;
import pojo.Van;
import pojo.Vehicle;
import types.VehicleType;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainTerminal extends Terminal implements ChoiceTerminal {

  private final int VIEW_TRUCKS_INDEX = 0;
  private final int REGISTER_NEW_TRUCK_INDEX = 1;

  public void initialize() {
    this.addChoice(VIEW_TRUCKS_INDEX, "View registered trucks");
    this.addChoice(REGISTER_NEW_TRUCK_INDEX, "Register new truck");
  }


  @Override
  public void handleUserChoice(int index) {
    if(index == VIEW_TRUCKS_INDEX) {
      Warehouse.getInstance().viewBays();
    } else if(index == REGISTER_NEW_TRUCK_INDEX) {
      registerNewTruck();
    } else {
      System.out.println("Invalid input");
    }
  }

  private void registerNewTruck() {
    List<String> vehiclesTypes = Arrays.asList("Van", "Light truck", "Heavy truck");
    Scanner scanner = new Scanner(System.in);
    String response = null;

    System.out.println("Vehicle type: ");
    for (int i = 0; i < vehiclesTypes.size(); i++) {
      System.out.println(i + " - " + vehiclesTypes.get(i));
    }
    response = scanner.nextLine();
    int vehicleType = Integer.parseInt(response);

    System.out.println("Vehicle weight: ");
    response = scanner.nextLine();
    int vehicleWeight = Integer.parseInt(response);

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


    Warehouse.getInstance().registerNewVehicle(vehicle);
  }
}