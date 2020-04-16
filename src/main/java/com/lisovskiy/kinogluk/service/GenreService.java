package com.lisovskiy.kinogluk.service;


import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.request.GenreRequest;

import java.util.List;

public interface GenreService {

List<Genre> findAll();
Genre findByTitle (String title);

    Genre save (GenreRequest request);

    Genre edit(int id, GenreRequest request);

    void deleteAll();

    void deleteById(int id);
}
