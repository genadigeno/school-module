package com.example.school.data.school;

import com.example.school.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {
    private SchoolJpaRepository schoolJpaRepository;

    public SchoolJpaRepository getSchoolJpaRepository() {
        return schoolJpaRepository;
    }

    @Autowired
    @Qualifier("schoolJpaRepository")
    public void setSchoolJpaRepository(SchoolJpaRepository schoolJpaRepository) {
        this.schoolJpaRepository = schoolJpaRepository;
    }

    @Override
    public School get(Integer id) {
        return schoolJpaRepository.getOne(id);
    }

    @Override
    public List<School> getAll() {
        return schoolJpaRepository.findAll();
    }
}
