package com.lisovskiy;

import com.lisovskiy.kinogluk.Game;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameCreateTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenCreateNewGame_thenCreated() {
        Game game = new Game();
        ResponseEntity<Game> response = restTemplate.postForEntity("/v1/games", game, Game.class);

        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(response.getBody().getId(), notNullValue());
        assertThat(response.getBody().getTitle(), is("Death Stranding"));
    }
}
