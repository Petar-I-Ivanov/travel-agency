package org.pufmi.reservation.model;

import static lombok.AccessLevel.PRIVATE;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.pufmi.holiday.model.ResponseHolidayDTO;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class ResponseReservationDTO {

  Long id;
  String contactName;
  String phoneNumber;
  ResponseHolidayDTO holiday;
}
