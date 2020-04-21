package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CreateCatalogTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void createTest() {
        Catalog catalog = new Catalog();
        catalog.setTitle("Want to play");
        Company company = new Company();
        company.setTitle("Kojima");
        List<Game> games = new ArrayList<>();
        Game game = new Game();
        game.setShortDescription("Very interesting game");
        game.setReleaseYear(LocalDate.of(2019,11,22));
        game.setRating(10);
        game.setTitle("Death Stranding");
        game.setCompany(company);
        games.add(game);
        catalog.setGames(games);
        catalogService.create(catalog);
        assertEquals(catalog.getTitle(), catalogService.findByTitle(catalog.getTitle()).getTitle());
    }



}
