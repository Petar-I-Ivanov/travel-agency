package org.pufmi.utility;

import java.util.Optional;
import org.pufmi.holiday.model.Holiday;
import org.pufmi.holiday.model.ResponseHolidayDTO;
import org.pufmi.location.model.Location;
import org.pufmi.location.model.ResponseLocationDTO;
import org.pufmi.reservation.model.Reservation;
import org.pufmi.reservation.model.ResponseReservationDTO;

public final class ModelMapper {

  private ModelMapper() {}

  public static ResponseHolidayDTO toHolidayDTO(Holiday entity) {
    return Optional.ofNullable(entity)
        .map(
            holiday ->
                ResponseHolidayDTO.builder()
                    .id(holiday.getId())
                    .location(toLocationDTO(holiday.getLocation()))
                    .title(holiday.getTitle())
                    .startDate(holiday.getStartDate())
                    .duration(holiday.getDuration())
                    .price(holiday.getPrice())
                    .freeSlots(holiday.getFreeSlots())
                    .build())
        .orElse(null);
  }

  public static ResponseLocationDTO toLocationDTO(Location entity) {
    return Optional.ofNullable(entity)
        .map(
            location ->
                ResponseLocationDTO.builder()
                    .id(location.getId())
                    .street(location.getStreet())
                    .number(location.getNumber())
                    .city(location.getCity())
                    .country(location.getCountry())
                    .imageUrl(location.getImageUrl())
                    .build())
        .orElse(null);
  }

  public static ResponseReservationDTO toReservationDTO(Reservation entity) {
    return Optional.ofNullable(entity)
        .map(
            reservation ->
                ResponseReservationDTO.builder()
                    .id(reservation.getId())
                    .contactName(reservation.getContactName())
                    .phoneNumber(reservation.getPhoneNumber())
                    .holiday(toHolidayDTO(reservation.getHoliday()))
                    .build())
        .orElse(null);
  }
}
