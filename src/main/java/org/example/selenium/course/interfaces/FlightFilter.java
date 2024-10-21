package org.example.selenium.course.interfaces;

import org.example.selenium.course.model.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> filter(List<Flight> flights);
}
