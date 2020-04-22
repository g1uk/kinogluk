package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GenreServiceTest {

    @Autowired
    GenreServiceImpl genreService;

    @Test
    public void create() {
        Genre genre = new Genre();
        genre.setTitle("Comedy");
        genreService.save(genre);
        assertEquals(genre.getTitle(), (genreService.findByTitle(genre.getTitle()).getTitle()));
    }

    @Test
    public void findAll() {
        List<Genre> genres = genreService.findAll();
        assertEquals(genres.size(), genreService.findAll().size());
    }

    @Test
    public void update() {
        Genre genre = new Genre();
        genre.setTitle("Test genre");
        genreService.save(genre);
        Genre original = new Genre();
        original.setTitle("Horror");
        assertEquals(original.getTitle(), genreService.update(genre.getId(), original).getTitle());
    }

    @Test
    public void delete() {
        Genre genre = new Genre();
        genre.setTitle("Test genre");
        genreService.save(genre);
        int result = genreService.findAll().size();
        genreService.deleteById(genre.getId());
        assertEquals(result-1, genreService.findAll().size());
    }

    @Test
    public void deleteByTitle() {
        Genre genre = new Genre();
        genre.setTitle("Test genre");
        genreService.save(genre);
        int result = genreService.findAll().size();
        genreService.deleteByTitle(genre.getTitle());
        assertEquals(result-1, genreService.findAll().size());
    }
}
