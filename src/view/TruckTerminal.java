package view;

import factory.VehicleFactory;
import pojo.Vehicle;

import java.util.Arrays;
import java.util.List;

public class TruckTerminal extends Terminal implements ChoiceTerminal {

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
    String response = null;
    int vehicleType = 0;
    int vehicleWeight = 0;

    while(vehicleType >= vehiclesTypes.size()) {
      vehicleType = queryIntegerInput("Vehicle type: ", vehiclesTypes);
    }

    /*while(response == null) {
      response = queryInput("Vehicle type: ", vehiclesTypes);

      if(response.matches("[0-9]")) {
        vehicleType = Integer.parseInt(response);

        if(vehicleType >= vehiclesTypes.size()) {
          response = null;
          System.out.println("Index was not in the list, try again");
        }
      } else {
        response = null;
        System.out.println("Not a digit, try again");
      }
    }*/

    response = null;
    while(response == null) {
      response = queryInput("Vehicle weight: ");

      if(response.matches("[0-9]+")) {
        vehicleWeight = Integer.parseInt(response);
      } else {
        response = null;
        System.out.println("Not a digit, try again");
      }
    }

    Vehicle vehicle = VehicleFactory.create(vehicleType, vehicleWeight);

    Warehouse.getInstance().registerNewVehicle(vehicle);

  }
}
