package com.example.school.data.school;

import com.example.school.model.School;

import java.util.List;

public interface SchoolService {
    School get(Integer id);
    List<School> getAll();
}
