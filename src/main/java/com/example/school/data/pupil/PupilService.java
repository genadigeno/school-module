package com.example.school.data.pupil;

import com.example.school.model.Pupil;

import java.util.List;

public interface PupilService {
    List<Pupil> getPupils(Integer page, Integer size);
    Pupil get(Integer id);
    void save(Pupil pupil);
}
