package org.pufmi.reservation.service;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.pufmi.reservation.model.Reservation;

@ApplicationScoped
public class ReservationRepository implements PanacheRepositoryBase<Reservation, Long> {}
