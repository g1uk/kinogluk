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

    @GetMapping("/game/title/{gameTitle}")
    public Game findByTitle(@PathVariable("gameTitle") String title) {
        return gameService.findByTitle(title);
    }

    @GetMapping("/game/rating/from/{ratingFrom:\\d+}/to/{ratingTo:\\d+}")
    public List<Game> findByRatingBetween(@PathVariable("ratingFrom") int from, @PathVariable("ratingTo") int to) {
        return gameService.findByRatingBetween(from, to);
    } //todo unbounded message

    @GetMapping("/game/releaseYear/from/{ratingFrom}/to/{ratingTo}")
    public List<Game> findByReleaseYearBetween(@PathVariable("ratingFrom") String from, @PathVariable("ratingTo") String to) {
        return gameService.findByReleaseYearBetween(from, to);
    } //todo unbounded message

    @PostMapping (value = "/game", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Game add(@RequestBody GameRequest request) {
        return gameService.save(request);
    }

    @PostMapping (value = "/game/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Game edit(@PathVariable("gameId") int id, @RequestBody GameRequest request) {
        return gameService.edit(id, request);
    }

    @GetMapping("/game/company/{gamesCompany}")
    public List<Game> findGamesByCompany(@PathVariable("gamesCompany") Company company) {
        return gameService.findGamesByCompany(company);
    }

    @GetMapping("/game/catalog/{gamesCatalog}")
    public List<Game> findGamesByCatalog(@PathVariable("gamesCatalog") Catalog catalog) {
        return gameService.findGamesByCatalog(catalog);
    }

    @GetMapping("/game/genre/{gamesGenre}")
    public List<Game> findGamesByGenre(@PathVariable("gamesGenre") Genre genre) {
        return gameService.findGamesByGenre(genre);
    }

    @PostMapping("/game/delete/{gameId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("gameId") int id) {
        gameService.deleteById(id);
    }

    @PostMapping(value = "/game/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByTitle(@RequestBody String title) {
        gameService.deleteByTitle(title);
    }
}
