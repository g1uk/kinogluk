package com.lisovskiy.kinogluk.service;


import com.lisovskiy.kinogluk.entity.Genre;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GenreService {

    List<Genre> findAll();
    Genre save (Genre genre);
    Genre findByTitle (String title);

    void deleteAll();
    void deleteById(int id);

    @Transactional
    void deleteByTitle(String title);
}
