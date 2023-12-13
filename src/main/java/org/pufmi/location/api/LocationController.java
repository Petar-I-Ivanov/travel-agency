package org.pufmi.location.api;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.WILDCARD;
import static lombok.AccessLevel.PRIVATE;
import static org.pufmi.utility.ModelMapper.toLocationDTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.pufmi.location.model.CreateLocationDTO;
import org.pufmi.location.model.ResponseLocationDTO;
import org.pufmi.location.model.UpdateLocationDTO;
import org.pufmi.location.service.LocationService;
import org.pufmi.utility.ModelMapper;

@Path("/locations")
@Consumes(APPLICATION_JSON)
@Produces(WILDCARD)
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LocationController {

  LocationService locationService;

  @POST
  public ResponseLocationDTO createLocation(@Valid CreateLocationDTO createRequest) {
    return toLocationDTO(locationService.createLocation(createRequest));
  }

  @DELETE
  @Path("/{id}")
  public boolean deleteLocationById(@PathParam("id") Long id) {
    return locationService.deleteLocationById(id);
  }

  @GET
  public List<ResponseLocationDTO> getAllLocations() {
    return locationService.getAllLocations().stream().map(ModelMapper::toLocationDTO).toList();
  }

  @GET
  @Path("/{id}")
  public ResponseLocationDTO getLocationById(@PathParam("id") Long id) {
    return toLocationDTO(locationService.getLocationById(id));
  }

  @PUT
  public ResponseLocationDTO updateLocation(@Valid UpdateLocationDTO updateRequest) {
    return toLocationDTO(locationService.updateLocation(updateRequest));
  }
}
