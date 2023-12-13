package org.pufmi.location.model;

import static lombok.AccessLevel.PRIVATE;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = PRIVATE)
public class CreateLocationDTO {

  String street;
  String number;
  String city;
  String country;
  String imageUrl;
}
