package org.pufmi.location.model;

import static lombok.AccessLevel.PRIVATE;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class ResponseLocationDTO {

  Long id;
  String street;
  String number;
  String city;
  String country;
  String imageUrl;
}
