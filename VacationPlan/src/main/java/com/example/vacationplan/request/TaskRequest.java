package com.example.vacationplan.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
