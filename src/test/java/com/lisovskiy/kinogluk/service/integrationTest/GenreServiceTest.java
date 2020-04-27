package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.exceptions.GenreNotFoundException;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GenreServiceTest {

    @Autowired
    GenreServiceImpl genreService;

    @Test
    public void create() {
        String title = "Comedy";
        Genre genre = new Genre();
        genre.setTitle(title);
        genreService.create(genre);
        assertEquals(genre.getTitle(), (genreService.findByTitle(genre.getTitle()).getTitle()));
    }

    @Test
    public void findAll() {
        List<Genre> genres = genreService.findAll();
        assertEquals(genres.size(), genreService.findAll().size());
    }

    @Test
    public void update() {
        String title = "Test genre";
        String newTitle = "Horror";
        Genre genre = new Genre();
        genre.setTitle(title);
        genreService.create(genre);
        Genre original = new Genre();
        original.setTitle(newTitle);
        assertEquals(original.getTitle(), genreService.update(genre.getId(), original).getTitle());
    }

    @Test
    public void delete() {
        String title = "Test genre";
        Genre genre = new Genre();
        genre.setTitle(title);
        genreService.save(genre);
        int genreId = genre.getId();
        Genre insertedGenre = genreService.findByTitle(title);
        assertNotNull(insertedGenre);
        genreService.deleteById(genreId);
        assertThrows(GenreNotFoundException.class, () -> {
           genreService.findByTitle(title);
        });
    }

    @Test
    public void deleteByTitle() {
        String title = "Test genre";
        Genre genre = new Genre();
        genre.setTitle(title);
        genreService.create(genre);
        Genre insertedGenre = genreService.findByTitle(title);
        assertNotNull(insertedGenre);
        genreService.deleteByTitle(title);
        assertThrows(GenreNotFoundException.class, () -> {
           genreService.findByTitle(title);
        });
    }
}
