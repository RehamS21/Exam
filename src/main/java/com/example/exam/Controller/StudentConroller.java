package com.example.exam.Controller;

import com.example.exam.ApiResponse.ApiResponse;
import com.example.exam.Model.Student;
import com.example.exam.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stu")
@RequiredArgsConstructor
public class StudentConroller {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(200).body(studentService.getAllstudent());

    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("New student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        boolean isupdate  = studentService.updateStudent(id, student);
        if (isupdate)
            return ResponseEntity.status(200).body(new ApiResponse("Student updated"));
        else
            return ResponseEntity.status(400).body(new ApiResponse("Sorry invalid student id"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        boolean isDeleted = studentService.deleteStudent(id);

        if (isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));
        else
            return ResponseEntity.status(400).body(new ApiResponse("sorry invalid student id"));
    }

    @GetMapping("/one/{name}")
    public ResponseEntity OneStudent(@PathVariable String name){
        Student oneS = studentService.getOneStudent(name);
        if (oneS != null)
            return ResponseEntity.status(200).body(oneS);
        else
            return ResponseEntity.status(400).body(new ApiResponse("Sorry student not found"));
    }

}
