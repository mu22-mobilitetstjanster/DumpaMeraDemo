package coordinator;

import pojo.Bay;
import pojo.Vehicle;

import java.util.List;
import java.util.Optional;

public class BayCoordinator implements BayService {

  private final List<Bay> bays;

  public BayCoordinator(List<Bay> bays) {
    this.bays = bays;
  }

  @Override
  public Bay add(Vehicle vehicle) {
    Optional<Bay> validBay = bays.stream().filter(bay ->
            bay.getVehicle() == null && // is there a vehicle in the bay?
            bay.getWeightRestriction() > vehicle.getWeight() && // does the vehicle fulfill weight requirement?
            bay.getVehicleRestrictions().contains(vehicle.getType()) // does the vehicle fulfill the type restriction requirement?
    ).findAny(); // take the first result from above criteria

    if(validBay.isPresent()) { // was a valid bay found?
      validBay.get().setVehicle(vehicle); // add vehicle to the valid bay
      return validBay.get(); // return the bay
    } else {
      return null; // no bay found, can be replaced with throw exception
    }
  }

  @Override
  public List<Bay> getAll() {
    return bays;
  }
}
