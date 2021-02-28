package com.example.school.data.classRoom;

import com.example.school.model.ClassRoom;
import com.example.school.model.School;

import java.util.List;

public interface ClassService {
    ClassRoom get(Integer id);
    List<ClassRoom> getAll();
    List<ClassRoom> getAllBySchool(School school);
}
