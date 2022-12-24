package com.example.vacationplan.response;

import com.example.vacationplan.entity.Flight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponse {

    private String airline;

    private int flightNumber;

    private String timeOfFlight;

    public FlightResponse(Flight flight){
        airline = flight.getAirline();
        flightNumber = flight.getFlightNumber();
        timeOfFlight = flight.getTimeOfFlight();
    }
}
