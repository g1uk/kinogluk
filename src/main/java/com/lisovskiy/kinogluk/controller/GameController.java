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
    public Game findByTitle(@PathVariable String gameTitle) {

        return gameService.findByTitle(gameTitle);
    }

    @PostMapping ("/game/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Game add(@RequestBody Game game) {
        return gameService.save(game);
    }

    @PostMapping ("/game/{idUpdate}")
    public Game update(@RequestBody Game game) {
        return gameService.edit(game);
    }

    @GetMapping("/game/{idDelete}")
    public void deleteById(@PathVariable int id) { gameService.deleteById(id);
    }

    @GetMapping("/game/{gameTitle}")
    public String deleteByTitle(@PathVariable String gameTitle) {
        return "Игра " + gameTitle + " удалена из библиотеки.";
    }

    @GetMapping("/game/{id}/")
    public String ratingUpdate (@RequestBody Game game, @PathVariable int id) {
        return "Спасибо за Вашу оценку.";
    }
}
