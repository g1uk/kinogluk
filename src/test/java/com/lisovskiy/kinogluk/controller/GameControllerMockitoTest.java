package com.lisovskiy.kinogluk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.entity.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerMockitoTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void findAllTest() throws Exception {
        mockMvc.perform(get("/v1/games")
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findByTitleTest() throws Exception {
        String title = "Witcher 3";
        mockMvc.perform(get("/v1/games/game/title/{gameTitle}", title)
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findByRatingBetweenTest() throws Exception {
        int from = 7;
        int to = 9;
        mockMvc.perform(get("/v1/games/game/rating/from/{ratingFrom:}/to/{ratingTo:}", from, to)
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findByReleaseYearBetween() throws Exception {
        String from = "2010-01-01";
        String to = "2011-01-01";
        mockMvc.perform(get("/v1/games/game/releaseYear/from/{releaseYearFrom}/to/{releaseYearTo}", from, to)
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findGamesByCompanyTest() throws Exception {
        String title = "cd red project";
        int id = 47;
        Company company = new Company();
        company.setTitle(title);
        mockMvc.perform(get("/v1/games/game/company/{gamesCompany}", id)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(company)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findGamesByCatalogTest() throws Exception {
        String title = "Best rpg games";
        int id = 48;
        Catalog catalog = new Catalog();
        catalog.setTitle(title);
        mockMvc.perform(get("/v1/games/game/catalog/{gamesCatalog}", id)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(catalog)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findGamesByGenreTest() throws Exception {
        String title = "rpg";
        int id = 113;
        Genre genre = new Genre();
        genre.setTitle(title);
        mockMvc.perform(get("/v1/games/game/genre/{gamesGenre}", id)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(genre)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createTest() throws Exception {

        Catalog catalog = new Catalog();
        catalog.setTitle("my catalog");

        Company company = new Company();
        company.setTitle("Ubisoft");

        Genre genre = new Genre();
        genre.setTitle("quest/adventure");
        List<Genre> genres = new ArrayList<>();
        genres.add(genre);

        Game game = new Game();
        game.setTitle("Assasin`s creed");
        game.setShortDescription("interesting history game");
        game.setRating(7);
        game.setReleaseYear(LocalDate.of(2013, 4, 11));
        game.setCatalog(catalog);
        game.setCompany(company);

        game.setGenres(genres);

        mockMvc.perform(post("/v1/games/game/create")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(game)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void updateTest() throws Exception {

        int gameId = 58;

//        Catalog catalog = new Catalog();
//        catalog.setTitle("super catalog");
//
//        Company company = new Company();
//        company.setTitle("Kojima");
//
//        Genre genre = new Genre();
//        genre.setTitle("adventure horror");
//        List<Genre> genres = new ArrayList<>();
//        genres.add(genre);

        Game game = new Game();
        game.setTitle("Warcraft");
        game.setShortDescription("old school game");
        game.setRating(10);
        game.setReleaseYear(LocalDate.of(2001, 10, 4));
//        game.setCatalog(catalog);
//        game.setCompany(company);
//        game.setGenres(genres);

        mockMvc.perform(post("/v1/games/game/update/{gameId}", gameId)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(game)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void deleteByIdTest() throws Exception {
        int id = 58;
        mockMvc.perform(post("/v1/games/game/{gameId}", id)
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteByTitleTest() throws Exception {
        String title = "Assasin`s creed";
        mockMvc.perform(post("/v1/games/game/delete")
        .contentType("application/json")
        .content(title))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
