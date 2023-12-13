package org.pufmi.reservation.model;

import static lombok.AccessLevel.PRIVATE;

import jakarta.ws.rs.QueryParam;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = PRIVATE)
public class SearchQueryReservation {

  @QueryParam("phoneNumber")
  String phoneNumber;
}
