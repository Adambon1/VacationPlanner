package com.example.vacationplan.controller;

import com.example.vacationplan.entity.Destination;
import com.example.vacationplan.entity.Task;
import com.example.vacationplan.request.DestinationRequest;
import com.example.vacationplan.request.TaskRequest;
import com.example.vacationplan.response.DestinationResponse;
import com.example.vacationplan.response.TaskResponse;
import com.example.vacationplan.service.DestinationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/destinations")
public class DestinationController {

    @Autowired
    DestinationService destinationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{destination_id}/tasks")
    public TaskResponse addTask(
            @PathVariable long destination_id,
            @Valid @RequestBody TaskRequest taskRequest
            ){
        return new TaskResponse(destinationService.addTask(destination_id, taskRequest));
    }

    @GetMapping("/{destinationId}/tasks")
    public List<TaskResponse> getAllTasks(@PathVariable long destinationId){
        List<Task> task = destinationService.getAllTasks(destinationId);
        List<TaskResponse> taskResponse = new ArrayList<>();
        for(int i = 0; i < task.size(); i++){
            taskResponse.add(new TaskResponse(task.get(i)));
        }

        return taskResponse;
    }

    @DeleteMapping("/{destinationId}/tasks")
    public void deleteAllTasks(@PathVariable long destinationId) { destinationService.deleteAllTasks(destinationId);}
    @GetMapping()
    public List<DestinationResponse> getAllDestinations(@RequestParam(required = false) String hotelName){

        List<Destination> destinations = destinationService.getAllDestinations(hotelName);
        List<DestinationResponse> destinationRespons = new ArrayList<>();
        destinations.forEach(destination -> {
            DestinationResponse destinationResponse = new DestinationResponse(destination);
            destinationRespons.add(destinationResponse);
        });
        return destinationRespons;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public DestinationResponse addDestination(@Valid @RequestBody DestinationRequest destinationRequest){
        Destination savedDestination = destinationService.addDestination(destinationRequest);

        return new DestinationResponse(savedDestination);
    }

    @PutMapping("/{id}")
    public DestinationResponse updateDestination
            (@PathVariable long id,
             @Valid @RequestBody DestinationRequest destinationRequest){

        Destination updatedDestination = destinationService.updateDestination(id, destinationRequest);
        return new DestinationResponse(updatedDestination);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable long id) { destinationService.deleteDestination(id); }
}
