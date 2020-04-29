package com.lisovskiy.kinogluk.service;


import com.lisovskiy.kinogluk.entity.Genre;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GenreService {

    List<Genre> findAll();
    Genre findByTitle (String title);

    void deleteAll();

    @Transactional
    void deleteByTitle(String title);
}
