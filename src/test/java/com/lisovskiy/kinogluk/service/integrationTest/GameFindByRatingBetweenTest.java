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
public class GameFindByRatingBetweenTest {

    @Autowired
    GameServiceImpl gameService;

    @Test
    public void finByRatingBetweenTest() {
        List<Game> games = gameService.findByRatingBetween(7, 9);
        assertEquals(1, games.size());
    }
}
