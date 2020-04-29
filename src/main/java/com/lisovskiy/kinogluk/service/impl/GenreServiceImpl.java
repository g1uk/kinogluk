package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.exceptions.GenreNotFoundException;
import com.lisovskiy.kinogluk.repository.GenreRepository;
import com.lisovskiy.kinogluk.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @PersistenceContext
    EntityManager entityManager;

     private final GenreRepository genreRepository;

    public GenreServiceImpl (GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() { return genreRepository.findAll(); }

    @Transactional
    public Genre create(Genre genre) {
        entityManager.persist(genre);
        return genre;
    }

    @Transactional
    public void delete(int id) {
        Genre genre = entityManager.find(Genre.class, id);
        if (genre != null) {
            entityManager.remove(genre);
        }
        else throw new GenreNotFoundException(id);
    }

    @Override
    public Genre findByTitle (String title) {
        Genre genre = genreRepository.findByTitle(title);
        if (genre == null) {
            throw new GenreNotFoundException(title);
        }
        return genre;
    }

    @Transactional
    public Genre update (int id, Genre genre) {
        Genre original = entityManager.find(Genre.class, id);
        if (original != null) {
            original.setTitle(genre.getTitle());
            entityManager.merge(original);
        }
        else throw new GenreNotFoundException(id);
        return original;
    }

    public void deleteAll() { genreRepository.deleteAll(); }

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        genreRepository.deleteByTitle(title);
    }
}
