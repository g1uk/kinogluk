package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.springframework.http.HttpStatus;
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
    public Game findByTitle(@PathVariable("gameTitle") String title) { return gameService.findByTitle(title); }

    @GetMapping("/game/rating/from/{ratingFrom:\\d+}/to/{ratingTo:\\d+}")
    public List<Game> findByRatingBetween(@PathVariable("ratingFrom") int from, @PathVariable("ratingTo") int to) {
        return gameService.findByRatingBetween(from, to);
    } //todo unbounded message

    @GetMapping("/game/releaseYear/from/{ratingFrom}/to/{ratingTo}")
    public List<Game> findByReleaseYearBetween(@PathVariable("ratingFrom") String from, @PathVariable("ratingTo") String to) {
        return gameService.findByReleaseYearBetween(from, to);
    } //todo unbounded message

    @PostMapping ("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game add(@RequestBody Game game) {
        return gameService.save(game);
    }

    @PostMapping ("/game/{gameId}")
    public Game edit(@PathVariable("gameId") int id, @RequestBody Game game) {
        return gameService.edit(id, game);
    }

    @PostMapping("/game/delete/{gameId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("gameId") int id) { gameService.deleteById(id); }

    @GetMapping("/game//delete/{gameTitle}")
    public void deleteByTitle(@PathVariable("gameTitle") String title) { gameService.deleteByTitle(title); }

    @GetMapping("/game/{id}/")
    public String ratingUpdate (@RequestBody Game game, @PathVariable int id) { return "Спасибо за Вашу оценку."; }
}
