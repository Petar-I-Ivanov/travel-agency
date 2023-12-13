package org.pufmi.reservation.model;

import static lombok.AccessLevel.PRIVATE;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.pufmi.holiday.model.Holiday;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Reservation {

  @Id @GeneratedValue Long id;
  String contactName;
  String phoneNumber;

  @ManyToOne
  @JoinColumn(name = "holiday_id")
  Holiday holiday;
}
