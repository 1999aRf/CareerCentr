package org.example.selenium.course;

import org.example.selenium.course.Builder.FlightBuilder;
import org.example.selenium.course.interfaces.FlightFilter;
import org.example.selenium.course.interfaces.filters.ArrivalBeforeDepartureFilter;
import org.example.selenium.course.interfaces.filters.DepartureBeforeNowFilter;
import org.example.selenium.course.interfaces.filters.GroundTimeMoreThanTwoHoursFilter;
import org.example.selenium.course.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("Все перелеты:");
        flights.forEach(System.out::println);

        // Фильтрация по вылету до текущего времени
        FlightFilter departureBeforeNowFilter = new DepartureBeforeNowFilter();
        List<Flight> filteredByDeparture = departureBeforeNowFilter.filter(flights);
        System.out.println("\nПерелеты, где вылет после текущего момента времени:");
        filteredByDeparture.forEach(System.out::println);

        // Фильтрация по сегментам с прилетом до вылета
        FlightFilter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredByArrival = arrivalBeforeDepartureFilter.filter(flights);
        System.out.println("\nПерелеты, где прилет происходит после вылета:");
        filteredByArrival.forEach(System.out::println);

        // Фильтрация по времени на земле больше 2 часов
        FlightFilter groundTimeMoreThanTwoHoursFilter = new GroundTimeMoreThanTwoHoursFilter();
        List<Flight> filteredByGroundTime = groundTimeMoreThanTwoHoursFilter.filter(flights);
        System.out.println("\nПерелеты с временем на земле менее 2 часов:");
        filteredByGroundTime.forEach(System.out::println);
    }
}