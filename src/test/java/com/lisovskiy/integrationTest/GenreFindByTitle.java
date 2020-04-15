package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class GenreFindByTitle {

    @Autowired
    GenreServiceImpl genreService;

    @Test
    public void findByTitleTest() {
        Genre genre = new Genre();
        genre.setTitle("New Genre");
        genreService.save(genre);
        assertEquals(genre.getTitle(), (genreService.findByTitle(genre.getTitle()).getTitle()));
    }
}
