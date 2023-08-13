package com.example.exam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "teacher id must not null")
    private Integer id;
    @NotEmpty(message = "teacher name must not empty")
    private String name;
    @NotNull(message = "teacher salary must not null")
    @Positive(message = "Teacher salary must be positive")
    private Integer salary;

}
