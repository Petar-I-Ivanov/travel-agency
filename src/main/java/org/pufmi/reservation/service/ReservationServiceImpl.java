package org.pufmi.reservation.service;

import static lombok.AccessLevel.PRIVATE;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.pufmi.holiday.service.HolidayService;
import org.pufmi.reservation.model.CreateReservationDTO;
import org.pufmi.reservation.model.Reservation;
import org.pufmi.reservation.model.SearchQueryReservation;
import org.pufmi.reservation.model.UpdateReservationDTO;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ReservationServiceImpl implements ReservationService {

  ReservationRepository reservationRepository;
  HolidayService holidayService;

  @Override
  public Reservation createReservation(CreateReservationDTO createRequest) {
    var reservation =
        Reservation.builder()
            .contactName(createRequest.getContactName())
            .phoneNumber(createRequest.getPhoneNumber())
            .holiday(
                Optional.ofNullable(createRequest.getHoliday())
                    .map(holidayService::getHolidayById)
                    .orElse(null))
            .build();
    reservationRepository.persist(reservation);
    return reservation;
  }

  @Override
  public Reservation getReservationById(Long id) {
    return reservationRepository.findById(id);
  }

  @Override
  public List<Reservation> getAllReservationsByCriteria(SearchQueryReservation search) {
    var phoneNumber = search.getPhoneNumber();

    var query = "FROM Reservation r WHERE 1=1";
    var params = new HashMap<String, Object>();

    if (phoneNumber != null) {
      query += " AND r.phoneNumber like '%:phoneNumber%'";
      params.put("phoneNumber", phoneNumber);
    }

    return reservationRepository.find(query, params).list();
  }

  @Override
  public Reservation updateReservation(UpdateReservationDTO updateRequest) {
    return Optional.ofNullable(updateRequest.getId())
        .map(this::getReservationById)
        .map(
            reservation -> {
              reservation.setContactName(updateRequest.getContactName());
              reservation.setPhoneNumber(updateRequest.getPhoneNumber());
              reservation.setHoliday(
                  Optional.ofNullable(updateRequest.getHoliday())
                      .map(holidayService::getHolidayById)
                      .orElse(null));
              reservationRepository.persist(reservation);
              return reservation;
            })
        .orElse(null);
  }

  @Override
  public boolean deleteReservationById(Long id) {
    return reservationRepository.deleteById(id);
  }
}
