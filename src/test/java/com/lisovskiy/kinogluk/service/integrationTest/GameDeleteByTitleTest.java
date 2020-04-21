package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.repository.GameRepository;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class GameDeleteByTitleTest {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    GameRepository gameRepository;

    @Test
    public void deleteByTitleTest() {
        List<Game> games = gameService.findAll();
        System.out.println(games.size());
        gameService.deleteByTitle("dota2");
        assertEquals(games.size()-1, gameService.findAll().size());
    }
}
