package com.example.exam.Service;

import com.example.exam.Model.Student;
import com.example.exam.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getAllteacher(){
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(Integer id , Teacher teacher){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.set(i , teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(Integer id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.remove(i);
                return true;
            }
        }
        return false;

    }

    public Teacher getOneTeacher(Integer id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id)
                return teachers.get(i);
        }
        return null;
    }
}
