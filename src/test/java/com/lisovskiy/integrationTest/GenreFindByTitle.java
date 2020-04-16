package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.request.GenreRequest;
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
        GenreRequest request = new GenreRequest();
        request.setTitle("New");
        genreService.save(request);
        assertEquals(request.getTitle(), (genreService.findByTitle(request.getTitle()).getTitle()));
    }
}
