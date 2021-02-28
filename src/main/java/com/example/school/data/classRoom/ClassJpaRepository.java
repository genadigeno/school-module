package com.example.school.data.classRoom;

import com.example.school.model.ClassRoom;
import com.example.school.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("classJpaRepository")
public interface ClassJpaRepository extends JpaRepository<ClassRoom, Integer> {
    List<ClassRoom> findAllBySchool(School school);
}
