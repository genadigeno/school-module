package com.example.school.data.dictionary;

import com.example.school.model.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

    private DictionaryJpaRepository dictionaryJpaRepository;

    public DictionaryJpaRepository getDictionaryJpaRepository() {
        return dictionaryJpaRepository;
    }

    @Autowired
    @Qualifier("dictionaryJpaRepository")
    public void setDictionaryJpaRepository(DictionaryJpaRepository dictionaryJpaRepository) {
        this.dictionaryJpaRepository = dictionaryJpaRepository;
    }

    @Override
    public List<Dictionary> getAll(String key) {
        return dictionaryJpaRepository.findAllByDictionaryKey(key);
    }

    @Override
    public Dictionary dictionary(Integer id) {
        return dictionaryJpaRepository.getOne(id);
    }

    @Override
    public List<Dictionary> getAllByParent(Dictionary parent) {
        return dictionaryJpaRepository.findAllByParent(parent);
    }

    @Override
    public Dictionary dictionary(String key) {
        return dictionaryJpaRepository.getByDictionaryKey(key);
    }
}
