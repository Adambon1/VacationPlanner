package com.example.vacationplan.controller;

import com.example.vacationplan.request.TaskRequest;
import com.example.vacationplan.response.TaskResponse;
import com.example.vacationplan.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{taskId}")
    public TaskResponse getTask(@PathVariable long taskId){
        return new TaskResponse(taskService.getTask(taskId));
    }

    @PutMapping("/{taskId}")
    public TaskResponse updateTask(@PathVariable long taskId, @Valid @RequestBody TaskRequest taskRequest){
        return new TaskResponse(taskService.updateTask(taskId, taskRequest));
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable long taskId){ taskService.deleteTask(taskId);}
}
