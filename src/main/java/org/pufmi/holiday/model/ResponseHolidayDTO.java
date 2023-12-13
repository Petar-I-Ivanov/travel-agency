package org.pufmi.holiday.model;

import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.pufmi.location.model.ResponseLocationDTO;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class ResponseHolidayDTO {

  Long id;
  ResponseLocationDTO location;
  String title;
  LocalDate startDate;
  Integer duration;
  Double price;
  Integer freeSlots;
}
