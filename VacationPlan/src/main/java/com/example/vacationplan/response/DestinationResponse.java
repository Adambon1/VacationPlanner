package com.example.vacationplan.response;

import com.example.vacationplan.entity.Destination;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DestinationResponse {

    private long id;

    private String country;

    private String city;

    private String hotelName;

    private FlightResponse flight;

    public DestinationResponse(Destination destination){
        id = destination.getId();
        country = destination.getCountry();
        city = destination.getCity();
        hotelName = destination.getHotelName();
        flight = new FlightResponse(destination.getFlight());
    }
}
