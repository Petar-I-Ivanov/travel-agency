package org.pufmi.holiday.model;

import static lombok.AccessLevel.PRIVATE;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.pufmi.location.model.Location;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Holiday {

  @Id @GeneratedValue Long id;
  String title;
  LocalDate startDate;
  Integer duration;
  Double price;
  Integer freeSlots;

  @ManyToOne
  @JoinColumn(name = "location_id")
  Location location;
}
