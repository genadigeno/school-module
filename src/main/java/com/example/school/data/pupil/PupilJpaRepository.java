package com.example.school.data.pupil;

import com.example.school.model.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("pupilJpaRepository")
public interface PupilJpaRepository extends JpaRepository<Pupil, Integer> {
}
