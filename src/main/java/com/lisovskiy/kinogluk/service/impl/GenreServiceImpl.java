package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.exceptions.GenreNotFoundException;
import com.lisovskiy.kinogluk.repository.GenreRepository;
import com.lisovskiy.kinogluk.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    GenreRepository genreRepository;

    public GenreServiceImpl (GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() { return genreRepository.findAll(); }

    @Override
    public Genre findByTitle (String title) {
        Genre genre = genreRepository.findByTitle(title);
        if (genre == null) {
            throw new GenreNotFoundException(title);
        }
        return genre;
    }

    @Override
    public Genre save (Genre genre) {return genreRepository.save(genre);}

    @Override
    public void deleteAll() { genreRepository.deleteAll(); }

    @Override
    public void deleteById(int id) {
        if (!genreRepository.existsById(id)) {
            throw new GenreNotFoundException(id);
        }
        genreRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        genreRepository.deleteByTitle(title);
    }
}
