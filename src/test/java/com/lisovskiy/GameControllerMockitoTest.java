package com.lisovskiy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.SimpleDateFormat;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerMockitoTest {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

//    @Test
//    public void findAllTest() throws ParseException {
//        Game game = new Game();
//        GameRepository gameRepository = mock(GameRepository.class);
//        GameController gameController = new GameController(gameRepository);
//        game.setGamesId(1);
//        game.setRating(8);
//        game.setShortDescription("super igra");
//        game.setReleaseYear(simpleDateFormat.parse("22.12.2007"));
//        game.setTitle("mad max");
//        when(gameController.findAll()).thenReturn(List.of(game));
//        List<Game> games = gameController.findAll();
//        assertEquals(1, games.size());
//        assertEquals(game, games.get(0));
//    }

    @Test
    public void saveTest() {

    }
}
