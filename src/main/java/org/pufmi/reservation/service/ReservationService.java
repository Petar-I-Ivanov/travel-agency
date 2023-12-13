package org.pufmi.reservation.service;

import java.util.List;
import org.pufmi.reservation.model.CreateReservationDTO;
import org.pufmi.reservation.model.Reservation;
import org.pufmi.reservation.model.SearchQueryReservation;
import org.pufmi.reservation.model.UpdateReservationDTO;

public interface ReservationService {

  Reservation createReservation(CreateReservationDTO createRequest);

  Reservation getReservationById(Long id);

  List<Reservation> getAllReservationsByCriteria(SearchQueryReservation search);

  Reservation updateReservation(UpdateReservationDTO updateRequest);

  boolean deleteReservationById(Long id);
}
