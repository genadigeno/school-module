package com.example.school.data.classRoom;

import com.example.school.model.ClassRoom;
import com.example.school.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("classService")
public class ClassServiceImpl implements ClassService {
    private ClassJpaRepository classJpaRepository;

    public ClassJpaRepository getClassJpaRepository() {
        return classJpaRepository;
    }

    @Autowired
    @Qualifier("classJpaRepository")
    public void setClassJpaRepository(ClassJpaRepository classJpaRepository) {
        this.classJpaRepository = classJpaRepository;
    }

    @Override
    public ClassRoom get(Integer id) {
        return classJpaRepository.getOne(id);
    }

    @Override
    public List<ClassRoom> getAll() {
        return classJpaRepository.findAll();
    }

    @Override
    public List<ClassRoom> getAllBySchool(School school) {
        return classJpaRepository.findAllBySchool(school);
    }
}
