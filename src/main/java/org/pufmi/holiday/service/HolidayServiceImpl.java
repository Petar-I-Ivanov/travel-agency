package org.pufmi.holiday.service;

import static lombok.AccessLevel.PRIVATE;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.pufmi.holiday.model.CreateHolidayDTO;
import org.pufmi.holiday.model.Holiday;
import org.pufmi.holiday.model.SearchQueryHoliday;
import org.pufmi.holiday.model.UpdateHolidayDTO;
import org.pufmi.location.service.LocationService;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class HolidayServiceImpl implements HolidayService {

  HolidayRepository holidayRepository;
  LocationService locationService;

  @Override
  public Holiday createHoliday(CreateHolidayDTO createRequest) {
    var holiday =
        Holiday.builder()
            .title(createRequest.getTitle())
            .startDate(createRequest.getStartDate())
            .duration(createRequest.getDuration())
            .price(Double.valueOf(createRequest.getPrice()))
            .freeSlots(createRequest.getFreeSlots())
            .location(
                Optional.ofNullable(createRequest.getLocation())
                    .map(locationService::getLocationById)
                    .orElse(null))
            .build();

    holidayRepository.persist(holiday);
    return holiday;
  }

  @Override
  public Holiday getHolidayById(Long id) {
    return holidayRepository.findById(id);
  }

  @Override
  public List<Holiday> getHolidaysByCriteria(SearchQueryHoliday search) {
    var location = search.getLocation();
    var startDate = search.getStartDate();
    var duration = search.getDuration();

    var query = "FROM Holiday h WHERE 1=1";
    var params = new HashMap<String, Object>();

    if (location != null) {
      query += " AND h.location.id = :location";
      params.put("location", location);
    }

    if (startDate != null) {
      query += " AND h.startDate = :startDate";
      params.put("startDate", startDate);
    }

    if (duration != null) {
      query += " AND h.duration = :duration";
      params.put("duration", duration);
    }

    return holidayRepository.find(query, params).list();
  }

  @Override
  public Holiday updateHoliday(UpdateHolidayDTO updateRequest) {
    return Optional.ofNullable(updateRequest.getId())
        .map(this::getHolidayById)
        .map(
            holiday -> {
              holiday.setTitle(updateRequest.getTitle());
              holiday.setStartDate(updateRequest.getStartDate());
              holiday.setDuration(updateRequest.getDuration());
              holiday.setPrice(Double.valueOf(updateRequest.getPrice()));
              holiday.setFreeSlots(updateRequest.getFreeSlots());
              holiday.setLocation(
                  Optional.ofNullable(updateRequest.getLocation())
                      .map(locationService::getLocationById)
                      .orElse(null));
              holidayRepository.persist(holiday);
              return holiday;
            })
        .orElse(null);
  }

  @Override
  public boolean deleteHolidayById(Long id) {
    return holidayRepository.deleteById(id);
  }
}
