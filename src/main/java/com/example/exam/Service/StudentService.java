package com.example.exam.Service;

import com.example.exam.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student>students = new ArrayList<>();

    public ArrayList<Student> getAllstudent(){
        return students;
    }


    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(Integer id , Student student){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id){
                students.set(i , student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(Integer id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id){
                students.remove(i);
                return true;
            }
        }
        return false;

    }

    public Student getOneStudent(String name){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name))
                return students.get(i);
        }
        return null;
    }


}
