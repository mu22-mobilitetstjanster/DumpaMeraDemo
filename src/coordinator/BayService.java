package coordinator;

import pojo.Bay;
import pojo.Vehicle;

import java.util.List;

public interface BayService {
  Bay add(Vehicle vehicle);
  List<Bay> getAll();
}
