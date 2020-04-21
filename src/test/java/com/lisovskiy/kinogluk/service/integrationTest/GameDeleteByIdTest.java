package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class GameDeleteByIdTest {

    @Autowired
    GameServiceImpl gameService;

    @Test
    public void deleteByIdTest() {
        List<Game> games = gameService.findAll();
        gameService.deleteById(games.get(1).getGameId());
        assertEquals(games.size()-1, (gameService.findAll().size()));
    }
}
