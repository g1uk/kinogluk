package com.lisovskiy.kinogluk.service;


import com.lisovskiy.kinogluk.entity.Genre;

import java.util.List;

public interface GenreService {

List<Genre> findAll();
Genre save (Genre genre);
Genre findByTitle (String title);
}
