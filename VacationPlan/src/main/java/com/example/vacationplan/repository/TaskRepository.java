package com.example.vacationplan.repository;

import com.example.vacationplan.entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    public List<Task> findAllByDestinationId(long destination_id);

    @Transactional
    void deleteAllByDestinationId(long destinationId);
}
