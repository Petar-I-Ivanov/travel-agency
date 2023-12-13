package org.pufmi.holiday.model;

import static lombok.AccessLevel.PRIVATE;

import jakarta.ws.rs.QueryParam;
import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = PRIVATE)
public class SearchQueryHoliday {

  @QueryParam("location")
  Long location;

  @QueryParam("startDate")
  LocalDate startDate;

  @QueryParam("duration")
  Integer duration;
}
