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
public class GenreDeleteById {

    @Autowired
    GenreServiceImpl genreService;

    @Test
    public void deleteByIdTest() {
        List<Genre> genres = genreService.findAll();
        genreService.deleteById(genres.get(1).getGenreId());
        assertEquals(genres.size()-1, (genreService.findAll().size()));
    }
}
