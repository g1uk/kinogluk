package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class GameFindByTitleTest {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    CatalogServiceImpl catalogService;

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void findByTitleTest() {
        Game game = new Game();
        game.setShortDescription("Test Description");
        game.setRating(8);
        game.setReleaseYear(LocalDate.of(1980, 05, 20));
        game.setTitle("New Game3");
        game.setCompany(companyService.findByTitle("New Company"));
        game.setCatalog(catalogService.findByTitle("New Catalog"));
        gameService.save(game);
        assertEquals(game.getTitle(), (gameService.findByTitle(game.getTitle()).getTitle()));
    }
}
