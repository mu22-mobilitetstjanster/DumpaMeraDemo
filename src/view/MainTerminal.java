package view;

import factory.VehicleFactory;
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

    /*System.out.println("Vehicle type: ");
    for (int i = 0; i < vehiclesTypes.size(); i++) {
      System.out.println(i + " - " + vehiclesTypes.get(i));
    }
    response = scanner.nextLine();*/



    try {

      response = queryInput("Vehicle type: ", vehiclesTypes);
      int vehicleType = Integer.parseInt(response);

      /*System.out.println("Vehicle weight: ");
      response = scanner.nextLine();*/

      response = queryInput("Vehicle weight: ");

      int vehicleWeight = Integer.parseInt(response);

      Vehicle vehicle = VehicleFactory.create(vehicleType, vehicleWeight);

      Warehouse.getInstance().registerNewVehicle(vehicle);

    } catch(NumberFormatException ex) {
      ex.printStackTrace();
    }
  }
}
