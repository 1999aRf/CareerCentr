package org.example.selenium.course.interfaces.filters;

import org.example.selenium.course.interfaces.FlightFilter;
import org.example.selenium.course.model.Flight;
import org.example.selenium.course.model.Segment;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class GroundTimeMoreThanTwoHoursFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    for (int i = 0; i < segments.size() - 1; i++) {
                        Segment currentSegment = segments.get(i);
                        Segment nextSegment = segments.get(i + 1);
                        Duration groundTime = Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate());
                        if (groundTime.toHours() > 2) {
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}
