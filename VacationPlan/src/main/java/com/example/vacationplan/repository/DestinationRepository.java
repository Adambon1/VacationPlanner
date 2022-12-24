package com.example.vacationplan.repository;

import com.example.vacationplan.entity.Destination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends CrudRepository<Destination, Long> {
    public List<Destination> findAllByHotelNameIgnoreCase(String hotelName);
}
