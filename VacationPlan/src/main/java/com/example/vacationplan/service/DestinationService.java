package com.example.vacationplan.service;

import com.example.vacationplan.entity.Destination;
import com.example.vacationplan.entity.Task;
import com.example.vacationplan.exception.ResourceNotFoundException;
import com.example.vacationplan.repository.DestinationRepository;
import com.example.vacationplan.repository.TaskRepository;
import com.example.vacationplan.request.DestinationRequest;
import com.example.vacationplan.request.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    @Autowired
    DestinationRepository destinationRepository;

    @Autowired
    TaskRepository taskRepository;

    public Task addTask(long destination_id, TaskRequest taskRequest){
        Destination destination = destinationRepository.findById(destination_id).orElseThrow(
                ()->new ResourceNotFoundException("Destination id is not found"));

        Task taskToBeSaved = new Task(taskRequest);
        taskToBeSaved.setDestination(destination);

        return taskRepository.save(taskToBeSaved);
    }

    public List<Task> getAllTasks(long destinationId) { return taskRepository.findAllByDestinationId(destinationId);}

    public void deleteAllTasks(long destinationId){
        if(destinationRepository.existsById(destinationId)){
            taskRepository.deleteAllByDestinationId(destinationId);
        }
        else{
            throw new ResourceNotFoundException("destination is not found");
        }
    }

    public List<Destination> getAllDestinations(String hotelNameParam){
        if(hotelNameParam == null || hotelNameParam.isBlank())
            return (List<Destination>) destinationRepository.findAll();

        return destinationRepository.findAllByHotelNameIgnoreCase(hotelNameParam);
    }

    public Destination addDestination(DestinationRequest destinationRequest){
        Destination destination = new Destination(destinationRequest);

        return destinationRepository.save(destination);
    }

    public Destination updateDestination(long destinationId, DestinationRequest destinationRequest){
        destinationRepository.findById(destinationId)
                .orElseThrow(()->new ResourceNotFoundException("destination id is not found"));

        Destination destinationToBeUpdated = new Destination(destinationRequest);
        destinationToBeUpdated.setId(destinationId);

        return destinationRepository.save(destinationToBeUpdated);
    }

    public void deleteDestination(long destinationId){
        if(destinationRepository.existsById(destinationId)){
            destinationRepository.deleteById(destinationId);
        }
        else{
            throw new ResourceNotFoundException("teacher id not found");
        }
    }
}
