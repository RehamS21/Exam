package com.example.exam.Controller;

import com.example.exam.ApiResponse.ApiResponse;
import com.example.exam.Model.Student;
import com.example.exam.Model.Teacher;
import com.example.exam.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getAllteacher());

    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("New teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Teacher teacher , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        boolean isupdate  = teacherService.updateTeacher(id, teacher);
        if (isupdate)
            return ResponseEntity.status(200).body(new ApiResponse("Teacher updated"));
        else
            return ResponseEntity.status(400).body(new ApiResponse("Sorry invalid teacher id"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        boolean isDeleted = teacherService.deleteTeacher(id);

        if (isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
        else
            return ResponseEntity.status(400).body(new ApiResponse("sorry invalid teacher id"));
    }

    @GetMapping("/one/{id}")
    public ResponseEntity OneTeacher(@PathVariable Integer id){
        Teacher oneTeacher  = teacherService.getOneTeacher(id);
        if (oneTeacher != null)
            return ResponseEntity.status(200).body(oneTeacher);
        else
            return ResponseEntity.status(400).body(new ApiResponse("Sorry teacher not found"));
    }
}
