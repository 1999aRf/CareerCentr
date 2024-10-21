package org.example.selenium.course.interfaces.filters;

import org.example.selenium.course.interfaces.FlightFilter;
import org.example.selenium.course.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return  flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}