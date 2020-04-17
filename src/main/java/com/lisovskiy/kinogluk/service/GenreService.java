package com.lisovskiy.kinogluk.service;


import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.request.GenreRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GenreService {

    Genre findByTitle (String title);
    Genre save (GenreRequest request);
    Genre edit(int id, GenreRequest request);
    List<Genre> findAll();
    void deleteAll();
    void deleteById(int id);

    @Transactional
    void deleteByTitle(String title);
}
