package com.example.vacationplan.entity;

import com.example.vacationplan.request.DestinationRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="destinations")
@Getter
@Setter
@NoArgsConstructor
public class Destination {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name="hotel_name", nullable = false)
    private String hotelName;
    @Column(name="country", nullable = false)
    private String country;

    @Column(name="city", nullable = false)
    private String city;


    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Flight flight;

    public Destination(DestinationRequest destinationRequest){
        hotelName = destinationRequest.getHotelName();
        country = destinationRequest.getCountry();
        city = destinationRequest.getCity();
    }
}
