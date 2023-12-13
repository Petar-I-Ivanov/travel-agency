package org.pufmi.holiday.model;

import static lombok.AccessLevel.PRIVATE;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.pufmi.holiday.service.validation.ValidDoubleValue;

@Data
@FieldDefaults(level = PRIVATE)
public class CreateHolidayDTO {

  Long location;

  String title;

  @Future(message = "The start date field, should be in the future")
  LocalDate startDate;

  @Min(value = 0, message = "The duration field, should be atleast 0")
  Integer duration;

  @ValidDoubleValue String price;

  @Min(value = 0, message = "The free slots field, should be atleast 0")
  Integer freeSlots;
}
