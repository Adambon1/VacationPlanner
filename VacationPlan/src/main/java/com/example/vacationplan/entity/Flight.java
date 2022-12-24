package com.example.vacationplan.entity;

import com.example.vacationplan.request.FlightRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="airline", nullable = false)
    private String airline;

    @Column(name="flight_number", nullable = false)
    private int flightNumber;

    @Column(name="time_of_flight", nullable = false)
    private String timeOfFlight;

    public Flight(FlightRequest flightRequest){
        airline = flightRequest.getAirline();
        flightNumber = flightRequest.getFlightNumber();
        timeOfFlight = flightRequest.getTimeOfFlight();
    }
}
