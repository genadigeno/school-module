package com.example.school.data.mark;

import com.example.school.model.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("markService")
public class MarkServiceImpl implements MarkService {
    private MarkJpaRepository markJpaRepository;

    public MarkJpaRepository getMarkJpaRepository() {
        return markJpaRepository;
    }

    @Autowired
    @Qualifier("markJpaRepository")
    public void setMarkJpaRepository(MarkJpaRepository markJpaRepository) {
        this.markJpaRepository = markJpaRepository;
    }

    @Override
    public void save(Mark mark) {
        markJpaRepository.save(mark);
    }

    @Override
    public Mark get(Integer id) {
        return markJpaRepository.getOne(id);
    }
}
