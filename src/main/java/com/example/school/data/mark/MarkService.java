package com.example.school.data.mark;

import com.example.school.model.Mark;

public interface MarkService {
    Mark get(Integer id);
    void save(Mark mark);
}
