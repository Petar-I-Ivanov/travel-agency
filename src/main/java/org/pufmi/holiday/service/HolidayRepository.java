package org.pufmi.holiday.service;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.pufmi.holiday.model.Holiday;

@ApplicationScoped
public class HolidayRepository implements PanacheRepositoryBase<Holiday, Long> {}
