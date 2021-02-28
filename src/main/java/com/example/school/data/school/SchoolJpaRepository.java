package com.example.school.data.school;

import com.example.school.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("schoolJpaRepository")
public interface SchoolJpaRepository extends JpaRepository<School, Integer> {
}
