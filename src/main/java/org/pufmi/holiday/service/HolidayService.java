package org.pufmi.holiday.service;

import java.util.List;
import org.pufmi.holiday.model.CreateHolidayDTO;
import org.pufmi.holiday.model.Holiday;
import org.pufmi.holiday.model.SearchQueryHoliday;
import org.pufmi.holiday.model.UpdateHolidayDTO;

public interface HolidayService {

  Holiday createHoliday(CreateHolidayDTO createRequest);

  Holiday getHolidayById(Long id);

  List<Holiday> getHolidaysByCriteria(SearchQueryHoliday search);

  Holiday updateHoliday(UpdateHolidayDTO updateRequest);

  boolean deleteHolidayById(Long id);
}
