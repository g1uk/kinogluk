package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class GameServiceIntegrationTest {

    @Autowired
    GameServiceImpl gameService;

    @Test
    public void saveTest() {
        Game game = new Game();
        game.setGameId(2);
        game.setRating(6);
        game.setShortDescription("not bad");

        game.setReleaseYear(new Date());
        game.setTitle("counter strike");
        Game savedGame = gameService.save(game);
        assertEquals(game, savedGame);

    }
}
