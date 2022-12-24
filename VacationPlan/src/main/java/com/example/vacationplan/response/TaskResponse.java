package com.example.vacationplan.response;

import com.example.vacationplan.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    private long id;

    private String title;

    private String description;

    private DestinationResponse destination;

    public TaskResponse(Task task){
        id = task.getId();
        title = task.getTitle();
        description = task.getDescription();
        destination = new DestinationResponse(task.getDestination());
    }
}
