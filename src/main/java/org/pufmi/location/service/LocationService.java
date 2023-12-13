package org.pufmi.location.service;

import java.util.List;
import org.pufmi.location.model.CreateLocationDTO;
import org.pufmi.location.model.Location;
import org.pufmi.location.model.UpdateLocationDTO;

public interface LocationService {

  Location createLocation(CreateLocationDTO createRequest);

  Location getLocationById(Long id);

  List<Location> getAllLocations();

  Location updateLocation(UpdateLocationDTO updateRequest);

  boolean deleteLocationById(Long id);
}
