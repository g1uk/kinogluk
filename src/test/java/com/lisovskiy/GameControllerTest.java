package com.lisovskiy;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.controller.GameController;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.repository.GameRepository;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import java.util.Date;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = KinoglukApplication.class)
public class GameControllerTest {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    GameRepository gameRepository;

    private static final String API_ROOT = "/v1/games";

    private Game createRandomGame() {
        Game game = new Game();
        Catalog catalog = new Catalog();
        Company company = new Company();
        Genre genre = new Genre();
        game.setRating((int) Math.random());
        game.setShortDescription(randomAlphabetic(50));
        game.setTitle(randomAlphabetic(10));
        game.setReleaseYear(new Date());
        return game;
    }

    private String createGameAsUri(Game game) {
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(game)
                .post(API_ROOT);
        return API_ROOT + "/game/" + response.jsonPath().get("id");
    }

    @Test
    public void allOperationWithCatalog() {
        Catalog catalog = new Catalog();
    }
    //throws

    @Test
    public void findAllTest() {
        GameController gameController = new GameController((new GameServiceImpl(gameRepository)));
        assertEquals(gameService.findAll(), gameController.findAll());
    }

    @Test
    public void saveTest() {
        Game game = createRandomGame();
        GameController gameController = new GameController((new GameServiceImpl(gameRepository)));
        assertEquals(gameController.add(game), game);
    }

    @Test
    public void updateTest() {
        GameController gameController = new GameController(new GameServiceImpl(gameRepository));
        List<Game> games = gameController.findAll();
        Game game = games.get(2);
        game.setRating(8);
        game.setShortDescription("nice game");
        game.setReleaseYear(new Date());
        game.setTitle("Warcraft");
        assertEquals(game, gameController.edit(game.getGameId(), game));
    }

    @Test
    public void deleteByIdTest() {
        GameController gameController = new GameController(new GameServiceImpl(gameRepository));
        List<Game> games = gameController.findAll();
        Game game = games.get(2);

        gameController.deleteById(game.getGameId());
        assertEquals((games.size() - 1), gameController.findAll().size());

    }
}

//    @Test
//    public void createGameTest() {
//        Game game = createRandomGame();
//        GameController gameController = new GameController(new GameRepository() {
//
//            @Override
//            public <S extends Game> Iterable<S> saveAll(Iterable<S> iterable) {
//                return null;
//            }
//
//            @Override
//            public Optional<Game> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @NotNull
//            @Override
//            public Game save(@NotNull Game game) {
//                return null;
//            }
//
//            @NotNull
//            @Override
//            public List<Game> findAll() {
//                return null;
//            }
//
//            @Override
//            public Iterable<Game> findAllById(Iterable<Long> iterable) {
//                return null;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(Game game) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends Game> iterable) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//        });
//        String result = gameController.add(game);
//        assertEquals("Игра " + game + " успешно добавлена в библиотеку.", result);
//    }
//    @Test
//    public void deleteByIdTest() {
//        Game game = createRandomGame();
//        Long id = game.getGamesId();
//        GameController gameController = new GameController(new GameRepository() {
//
//            @Override
//            public <S extends Game> Iterable<S> saveAll(Iterable<S> iterable) {
//                return null;
//            }
//
//            @Override
//            public Optional<Game> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @NotNull
//            @Override
//            public Game save(@NotNull Game game) {
//                return null;
//            }
//
//            @NotNull
//            @Override
//            public List<Game> findAll() {
//                return null;
//            }
//
//            @Override
//            public Iterable<Game> findAllById(Iterable<Long> iterable) {
//                return null;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(Game game) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends Game> iterable) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//        });
//        String result = gameController.deleteById(id);
//        assertEquals("Выбранная игра удалена из библиотеки.", result);
//    }
//    @Test
//    public void deleteByTitleTest() {
//        Game game = createRandomGame();
//        String title = game.getTitle();
//        GameController gameController = new GameController(new GameRepository() {
//
//            @Override
//            public <S extends Game> Iterable<S> saveAll(Iterable<S> iterable) {
//                return null;
//            }
//
//            @Override
//            public Optional<Game> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @NotNull
//            @Override
//            public Game save(@NotNull Game game) {
//                return null;
//            }
//
//            @NotNull
//            @Override
//            public List<Game> findAll() {
//                return null;
//            }
//
//            @Override
//            public Iterable<Game> findAllById(Iterable<Long> iterable) {
//                return null;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(Game game) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends Game> iterable) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//        });
//        String result = gameController.deleteByTitle(title);
//        assertEquals("Игра " + title + " удалена из библиотеки.", result);
//    }
//    @Test
//    public void ratingUpdateTest() {
//        Game game = createRandomGame();
//        Long id = game.getGamesId();
//        GameController gameController = new GameController(new GameRepository() {
//
//            @Override
//            public <S extends Game> Iterable<S> saveAll(Iterable<S> iterable) {
//                return null;
//            }
//
//            @Override
//            public Optional<Game> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @NotNull
//            @Override
//            public Game save(@NotNull Game game) {
//                return null;
//            }
//
//            @NotNull
//            @Override
//            public List<Game> findAll() {
//                return null;
//            }
//
//            @Override
//            public Iterable<Game> findAllById(Iterable<Long> iterable) {
//                return null;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(Game game) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends Game> iterable) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//        });
//        String result = gameController.ratingUpdate(game, id);
//        assertEquals("Спасибо за Вашу оценку.", result);
//
//    }