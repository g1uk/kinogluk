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
public class GenreDeleteByTitleTest {

    @Autowired
    GenreServiceImpl genreService;

    @Test
    public void deleteByTitle() {
        List<Genre> genres = genreService.findAll();
        genreService.deleteByTitle(genres.get(0).getTitle());
        assertEquals(genres.size()-1, genreService.findAll().size());
    }

}
