package com.lisovskiy;

import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.repository.GameRepository;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceMockitoTest {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Test
    public void findAllTest() throws ParseException {
        Game game = new Game();
        GameRepository gameRepository = mock(GameRepository.class);
        GameServiceImpl gameService = new GameServiceImpl(gameRepository);
        game.setGameId(1);
        game.setRating(8);
        game.setShortDescription("super igra");
        game.setReleaseYear(simpleDateFormat.parse("22.12.2007"));
        game.setTitle("mad max");
        when(gameService.findAll()).thenReturn(List.of(game));
        List<Game> games = gameService.findAll();
        assertEquals(1, games.size());
        assertEquals(game, games.get(0));
    }
}
