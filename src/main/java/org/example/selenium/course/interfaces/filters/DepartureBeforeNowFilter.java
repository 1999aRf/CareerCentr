package org.example.selenium.course.interfaces.filters;

import org.example.selenium.course.interfaces.FlightFilter;
import org.example.selenium.course.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeNowFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream().
                        allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .collect(Collectors.toList());
    }
}
