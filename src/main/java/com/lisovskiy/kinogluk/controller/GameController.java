package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.request.GameRequest;
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

    @GetMapping(value = "/game/releaseYear/from/{ratingFrom}/to/{ratingTo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> findByReleaseYearBetween(@PathVariable("ratingFrom") String from, @PathVariable("ratingTo") String to) {
        return gameService.findByReleaseYearBetween(from, to);
    } //todo unbounded message

    @PostMapping (value = "/game", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Game add(@RequestBody GameRequest request) {
        return gameService.save(request);
    }

    @PostMapping (value = "/game/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Game edit(@PathVariable("gameId") int id, @RequestBody GameRequest request) {
        return gameService.edit(id, request);
    }

    @GetMapping(value = "/game/company/{gamesCompany}", consumes = MediaType.APPLICATION_JSON_VALUE)
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

    @PostMapping(value = "/game/delete/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("gameId") int id) {
        gameService.deleteById(id);
    }

    @PostMapping(value = "/game/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByTitle(@RequestBody String title) {
        gameService.deleteByTitle(title);
    }
}
