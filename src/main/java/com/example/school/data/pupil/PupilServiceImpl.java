package com.example.school.data.pupil;

import com.example.school.model.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service("pupilService")
public class PupilServiceImpl implements PupilService {

    private PupilJpaRepository pupilJpaRepository;

    public PupilJpaRepository getPupilJpaRepository() { return pupilJpaRepository; }

    @Autowired
    @Qualifier("pupilJpaRepository")
    public void setPupilJpaRepository(PupilJpaRepository pupilJpaRepository) {
        this.pupilJpaRepository = pupilJpaRepository;
    }

    @Override
    public List<Pupil> getPupils(Integer page, Integer size) {
        if (page == null || size == null) return null;
        Pageable pageable = PageRequest.of(page, size);
        return pupilJpaRepository.findAll(pageable).getContent();
    }

    @Override
    public Pupil get(Integer id) {
        if (id == null || id == 0) return null;
        return pupilJpaRepository.getOne(id);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(Pupil entity) {
        pupilJpaRepository.save(entity);
    }
}
