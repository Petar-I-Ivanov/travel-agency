package org.pufmi.location.service;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.pufmi.location.model.Location;

@ApplicationScoped
public class LocationRepository implements PanacheRepositoryBase<Location, Long> {}
