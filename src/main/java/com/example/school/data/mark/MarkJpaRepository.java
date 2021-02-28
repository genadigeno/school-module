package com.example.school.data.mark;

import com.example.school.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("markJpaRepository")
public interface MarkJpaRepository extends JpaRepository<Mark, Integer> {
}
