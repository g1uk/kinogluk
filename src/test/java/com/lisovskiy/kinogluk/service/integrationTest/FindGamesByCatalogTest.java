package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = KinoglukApplication.class)
public class FindGamesByCatalogTest {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void findGamesByCatalog() {
        Catalog catalog = catalogService.findByTitle("Favourite");
        List<Game> games = gameService.findGamesByCatalog(catalog);
        assertEquals(1, games.size());
        System.out.println(games.get(0).getTitle());
    }

}
