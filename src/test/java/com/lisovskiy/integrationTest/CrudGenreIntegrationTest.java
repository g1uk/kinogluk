package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CrudGenreIntegrationTest {

    @Autowired
    GenreServiceImpl genreService;

    @Test
    public void CrudTestGenre() {
        genreService.deleteAll();
        Genre genre = new Genre();
        genre.setTitle("Test Genre");
        genreService.save(genre);
        genre.setTitle("UpdateTest Genre");
        genreService.save(genre);
        List<Genre> genres = genreService.findAll();
        assertEquals(1, genres.size());
        System.out.println(genres.get(0).getTitle());
    }
}
