package com.example.vacationplan.entity;

import com.example.vacationplan.request.TaskRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "destination_id")
    private Destination destination;

    public Task(TaskRequest taskRequest){
        title = taskRequest.getTitle();
        description = taskRequest.getDescription();
    }
}
