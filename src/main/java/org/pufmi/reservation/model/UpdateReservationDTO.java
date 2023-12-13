package org.pufmi.reservation.model;

import static lombok.AccessLevel.PRIVATE;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = PRIVATE)
public class UpdateReservationDTO {

  Long id;
  String contactName;
  String phoneNumber;
  Long holiday;
}
