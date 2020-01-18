package com.lisovskiy;

import com.lisovskiy.kinogluk.Game;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootBootstrapLiveTest {

//    @Autowired
//    private TestRestTemplate restTemplate;

    private static final String API_ROOT
            = "http://localhost:10127/v1/games";

    private Game createRandomGame() {
        Game game = new Game();
        game.setTitle(randomAlphabetic(10));
        return game;
    }

    private String createGameAsUri(Game game) {
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(game)
                .post(API_ROOT);
        return API_ROOT + "/game/" + response.jsonPath().get("id");
    }
    //read
    @Test
    public void whenGetAllGames_thenOK() {
        Response response = RestAssured.get(API_ROOT);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
    @Test
    public void whenGetGamesByTitle_thenOK() {
        Game game = createRandomGame();
        createGameAsUri(game);
        Response response = RestAssured.get(
                API_ROOT + "/game/title/" + game.getTitle());

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class)
                .size() > 0);
    }
    @Test
    public void whenGetCreatedGameById_thenOK() {
        Game game = createRandomGame();
        String location = createGameAsUri(game);
        Response response = RestAssured.get(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(game.getTitle(), response.jsonPath()
                .get("title"));
    }
    @Test
    public void whenGetNotExistGameById_thenNotFound() {
        Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
    //create
//    @Test
//    public void whenCreateNewGame_thenCreated() {
//        Game game = new Game("Death Stranding");
//        ResponseEntity<Game> response = restTemplate.postForEntity("/v1/games/game", game, Game.class);
//
//        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
//        assertThat(response.getBody().getId(), notNullValue());
//        assertThat(response.getBody().getTitle(), is("Death Stranding"));
//
//    }
    @Test
    public void whenInvalidGame_thenError() {
        Game game = createRandomGame();
        game.setTitle(null);
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(game)
                .post(API_ROOT);

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }
    //update
    @Test
    public void whenUpdateCreatedGame_thenUpdated() {
        Game game = createRandomGame();
        String location = createGameAsUri(game);
        game.setId(Long.parseLong(location.split("api/games/")[1]));
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(game)
                .put(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
    //delete
    @Test
    public void whenDeleteCreatedGame_thenOk() {
        Game game = createRandomGame();
        String location = createGameAsUri(game);
        Response response = RestAssured.delete(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }


}
