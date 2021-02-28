package com.example.school.data.dictionary;

import com.example.school.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dictionaryJpaRepository")
public interface DictionaryJpaRepository extends JpaRepository<Dictionary, Integer> {
    List<Dictionary> findAllByDictionaryKey(String dictionaryKey);
    Dictionary getByDictionaryKey(String dictionaryKey);
    List<Dictionary> findAllByParent(Dictionary parent);
}
