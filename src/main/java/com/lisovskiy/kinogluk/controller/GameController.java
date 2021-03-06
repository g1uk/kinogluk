package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/games")
public class GameController {

    private final GameServiceImpl gameService;

    public GameController (GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @GetMapping(value = "/game/title/{gameTitle}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Game findByTitle(@PathVariable("gameTitle") String title) {
        return gameService.findByTitle(title);
    }

    @GetMapping(value = "/game/rating/from/{ratingFrom:\\d+}/to/{ratingTo:\\d+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> findByRatingBetween(@PathVariable("ratingFrom") int from, @PathVariable("ratingTo") int to) {
        return gameService.findByRatingBetween(from, to);
    } //todo unbounded message

    @GetMapping(value = "/game/releaseYear/from/{releaseYearFrom}/to/{releaseYearTo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> findByReleaseYearBetween(@PathVariable("releaseYearFrom") String from, @PathVariable("releaseYearTo") String to) {
        return gameService.findByReleaseYearBetween(from, to);
    } //todo unbounded message

    @GetMapping(value = "/game/company/{gamesCompany}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> findGamesByCompany(@PathVariable("gamesCompany") Company company) {
        return gameService.findGamesByCompany(company);
    }

    @GetMapping(value = "/game/catalog/{gamesCatalog}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> findGamesByCatalog(@PathVariable("gamesCatalog") Catalog catalog) {
        return gameService.findGamesByCatalog(catalog);
    }

    @GetMapping(value = "/game/genre/{gamesGenre}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> findGamesByGenre(@PathVariable("gamesGenre") Genre genre) {
        return gameService.findGamesByGenre(genre);
    }

    @PostMapping(value = "/game/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Game game) {
        gameService.create(game);
    }

    @PostMapping(value = "/game/update/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update (@PathVariable("gameId") int id, @RequestBody Game game) {
        gameService.update(id, game);
    }

    @PostMapping(value = "/game/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("gameId") int id) {
        gameService.delete(id);
    }

    @PostMapping(value = "/game/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByTitle(@RequestBody String title) {
        gameService.deleteByTitle(title);
    }
}
