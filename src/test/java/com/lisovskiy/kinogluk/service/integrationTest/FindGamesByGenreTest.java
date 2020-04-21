package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class FindGamesByGenreTest {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    GenreServiceImpl genreService;

    @Test
    public void findGamesByGenreTest() {
        Genre genre = genreService.findByTitle("sport");
        List<Game> games = gameService.findGamesByGenre(genre);
        assertEquals(1, games.size());
        System.out.println(games.get(0).getTitle());
    }

}
