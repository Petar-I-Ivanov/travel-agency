package org.pufmi.reservation.api;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.WILDCARD;
import static lombok.AccessLevel.PRIVATE;
import static org.pufmi.utility.ModelMapper.toReservationDTO;

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
import org.pufmi.reservation.model.CreateReservationDTO;
import org.pufmi.reservation.model.ResponseReservationDTO;
import org.pufmi.reservation.model.SearchQueryReservation;
import org.pufmi.reservation.model.UpdateReservationDTO;
import org.pufmi.reservation.service.ReservationService;
import org.pufmi.utility.ModelMapper;

@Path("/reservations")
@Consumes(APPLICATION_JSON)
@Produces(WILDCARD)
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ReservationController {

  ReservationService reservationService;

  @POST
  public ResponseReservationDTO createReservation(@Valid CreateReservationDTO createRequest) {
    return toReservationDTO(reservationService.createReservation(createRequest));
  }

  @DELETE
  @Path("/{id}")
  public boolean deleteReservationById(@PathParam("id") Long id) {
    return reservationService.deleteReservationById(id);
  }

  @GET
  public List<ResponseReservationDTO> getAllReservationsByCriteria(SearchQueryReservation search) {
    return reservationService.getAllReservationsByCriteria(search).stream()
        .map(ModelMapper::toReservationDTO)
        .toList();
  }

  @GET
  @Path("/{id}")
  public ResponseReservationDTO getReservationById(@PathParam("id") Long id) {
    return toReservationDTO(reservationService.getReservationById(id));
  }

  @PUT
  public ResponseReservationDTO updateReservation(@Valid UpdateReservationDTO updateRequest) {
    return toReservationDTO(reservationService.updateReservation(updateRequest));
  }
}
