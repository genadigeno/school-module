package com.example.school.data.dictionary;

import com.example.school.model.Dictionary;

import java.util.List;

public interface DictionaryService {
    List<Dictionary> getAll(String key);
    List<Dictionary> getAllByParent(Dictionary parent);
    Dictionary dictionary(String key);
    Dictionary dictionary(Integer id);
}
