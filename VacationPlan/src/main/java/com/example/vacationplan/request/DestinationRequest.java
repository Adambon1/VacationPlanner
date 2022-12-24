package com.example.vacationplan.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationRequest {

    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private String hotelName;
    @NotNull
    @Valid
    private FlightRequest flight;

}
