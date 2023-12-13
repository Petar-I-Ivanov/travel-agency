package org.pufmi.location.service;

import static lombok.AccessLevel.PRIVATE;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.pufmi.location.model.CreateLocationDTO;
import org.pufmi.location.model.Location;
import org.pufmi.location.model.UpdateLocationDTO;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LocationServiceImpl implements LocationService {

  LocationRepository locationRepository;

  @Override
  public Location createLocation(CreateLocationDTO createRequest) {
    var location =
        Location.builder()
            .street(createRequest.getStreet())
            .number(createRequest.getNumber())
            .city(createRequest.getCity())
            .country(createRequest.getCountry())
            .imageUrl(createRequest.getImageUrl())
            .build();
    locationRepository.persist(location);
    return location;
  }

  @Override
  public Location getLocationById(Long id) {
    return locationRepository.findById(id);
  }

  @Override
  public List<Location> getAllLocations() {
    return locationRepository.findAll().list();
  }

  @Override
  public Location updateLocation(UpdateLocationDTO updateRequest) {
    return Optional.ofNullable(updateRequest.getId())
        .map(this::getLocationById)
        .map(
            location -> {
              location.setStreet(updateRequest.getStreet());
              location.setNumber(updateRequest.getNumber());
              location.setCity(updateRequest.getCity());
              location.setCountry(updateRequest.getCountry());
              location.setImageUrl(updateRequest.getImageUrl());
              locationRepository.persist(location);
              return location;
            })
        .orElse(null);
  }

  @Override
  public boolean deleteLocationById(Long id) {
    return locationRepository.deleteById(id);
  }
}
