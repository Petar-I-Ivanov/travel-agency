package org.pufmi.holiday.api;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.WILDCARD;
import static lombok.AccessLevel.PRIVATE;
import static org.pufmi.utility.ModelMapper.toHolidayDTO;

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
import org.pufmi.holiday.model.CreateHolidayDTO;
import org.pufmi.holiday.model.ResponseHolidayDTO;
import org.pufmi.holiday.model.SearchQueryHoliday;
import org.pufmi.holiday.model.UpdateHolidayDTO;
import org.pufmi.holiday.service.HolidayService;
import org.pufmi.utility.ModelMapper;

@Path("/holidays")
@Consumes(APPLICATION_JSON)
@Produces(WILDCARD)
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class HolidayController {

  HolidayService holidayService;

  @POST
  public ResponseHolidayDTO createHoliday(@Valid CreateHolidayDTO createRequest) {
    return toHolidayDTO(holidayService.createHoliday(createRequest));
  }

  @DELETE
  @Path("/{id}")
  public boolean deleteHolidayById(@PathParam("id") Long id) {
    return holidayService.deleteHolidayById(id);
  }

  @GET
  public List<ResponseHolidayDTO> getHolidaysByCriteria(SearchQueryHoliday search) {
    return holidayService.getHolidaysByCriteria(search).stream()
        .map(ModelMapper::toHolidayDTO)
        .toList();
  }

  @GET
  @Path("/{id}")
  public ResponseHolidayDTO getHolidayById(@PathParam("id") Long id) {
    return toHolidayDTO(holidayService.getHolidayById(id));
  }

  @PUT
  public ResponseHolidayDTO updateHoliday(@Valid UpdateHolidayDTO updateRequest) {
    return toHolidayDTO(holidayService.updateHoliday(updateRequest));
  }
}
