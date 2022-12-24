package com.example.vacationplan.service;

import com.example.vacationplan.entity.Task;
import com.example.vacationplan.exception.ResourceNotFoundException;
import com.example.vacationplan.repository.TaskRepository;
import com.example.vacationplan.request.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task getTask(long taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(()->new ResourceNotFoundException("task not found"));
        return task;
    }

    public Task updateTask(long taskId, TaskRequest taskRequest){
        if(taskRepository.existsById(taskId)){
            Task taskToBeUpdated = new Task(taskRequest);
            taskToBeUpdated.setId(taskId);
            return taskRepository.save(taskToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("task id not found");
        }
    }

    public void deleteTask(long taskId){
        if(taskRepository.existsById(taskId)){
            taskRepository.deleteById(taskId);
        }
        else{
            throw new ResourceNotFoundException("task id not found");
        }
    }
}
