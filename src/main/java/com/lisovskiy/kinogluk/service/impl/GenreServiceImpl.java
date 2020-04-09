package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.repository.GenreRepository;
import com.lisovskiy.kinogluk.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    GenreRepository genreRepository;

    public GenreServiceImpl (GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll() { return genreRepository.findAll(); }

    public Genre getByTitle (String title) { return genreRepository.findByTitle(title); }

    public Genre save (Genre genre) {return genreRepository.save(genre);}
}
