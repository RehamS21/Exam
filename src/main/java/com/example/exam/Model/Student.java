package com.example.exam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "student id must not null")
    @Positive(message = "Student id must be positive")
    private Integer id;
    @NotEmpty(message = "student name must not empty")
    private String name;
    @NotNull(message = "student age must not null")
    @Positive(message = "Student age must be positive")
    private Integer age;
    @NotEmpty(message = "student major must not empty")
    private String major;
}
