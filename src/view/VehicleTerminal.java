package view;

import factory.VehicleFactory;
import pojo.Vehicle;
import validation.VehicleValidation;

import java.util.Arrays;
import java.util.List;

public class VehicleTerminal extends Terminal implements ChoiceTerminal {

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

    int vehicleType = queryIntegerInput("Vehicle type: ", vehiclesTypes, (input) -> input < vehiclesTypes.size());
    int vehicleWeight = queryIntegerInput("Vehicle weight: ");


    Vehicle vehicle = VehicleFactory.create(vehicleType, vehicleWeight);

    Warehouse.getInstance().registerNewVehicle(vehicle);

  }

}
