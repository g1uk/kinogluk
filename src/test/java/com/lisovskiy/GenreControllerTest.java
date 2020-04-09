package com.lisovskiy;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.controller.GenreController;
import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.repository.GenreRepository;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class GenreControllerTest {

   @Autowired
   GenreServiceImpl genreService;

   @Autowired
   GenreRepository genreRepository;

   private Genre createRandomGenre() {
       Genre genre = new Genre();
       genre.setTitle(randomAlphabetic(10));
       return genre;
   }

   @Test
   public void findAllTest() {
       GenreController genreController = new GenreController(new GenreServiceImpl(genreRepository));
       assertEquals(genreRepository.findAll(), genreController.findAll());
   }

   @Test
    public void saveTest() {
       Genre genre = createRandomGenre();
       GenreController genreController = new GenreController(new GenreServiceImpl(genreRepository));
       assertEquals(genre, genreController.add(genre));
   }

}
