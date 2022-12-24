package com.example.vacationplan.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequest {
    @NotBlank
    private String airline;
    @NotNull
    private Integer flightNumber;
    @NotBlank
    private String timeOfFlight;
}
