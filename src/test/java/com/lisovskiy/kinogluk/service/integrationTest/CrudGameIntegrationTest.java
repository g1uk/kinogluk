package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.repository.GameRepository;
import com.lisovskiy.kinogluk.request.GameRequest;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CrudGameIntegrationTest {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    CatalogServiceImpl catalogService;

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void CrudTestGame() {
        Game game = new Game();
        game.setTitle("Test Game");
        game.setReleaseYear(LocalDate.of(1998, 10, 24));
        game.setRating(10);
        game.setShortDescription("Test Description");
        game.setCatalog(catalogService.findByTitle("New Test catalog"));
        game.setCompany(companyService.findByTitle("New Test Company"));
        GameRequest request = new GameRequest();
        request.setTitle("New Test Game");
        request.setReleaseYear(LocalDate.of(1999, 9, 23));
        request.setRating(8);
        request.setShortDescription("New Test Description");
        request.setCatalog(catalogService.findByTitle("New Test catalog"));
        request.setCompany(companyService.findByTitle("New Test Company"));
        gameService.edit(game.getGameId(), request);
        List<Game> games = gameService.findAll();
        assertEquals(1, games.size());
        System.out.println(games.get(0).getTitle());
    }

}
