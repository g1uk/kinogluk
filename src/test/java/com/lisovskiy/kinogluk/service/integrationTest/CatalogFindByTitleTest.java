package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CatalogFindByTitleTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void findByTitleTest() {
        Catalog catalog = new Catalog();
        catalog.setTitle("My catalog");
        List<Game> games = new ArrayList<>();
        Game game = new Game();
        game.setShortDescription("bad game");
        game.setReleaseYear(LocalDate.of(2011,11,22));
        game.setRating(8);
        game.setTitle("Mad Max");
        games.add(game);
        catalog.setGames(games);
        catalogService.create(catalog);
        assertEquals(catalog.getTitle(), catalogService.findByTitle(catalog.getTitle()).getTitle());
    }
}
