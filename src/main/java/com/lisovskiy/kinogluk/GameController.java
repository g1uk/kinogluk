package com.lisovskiy.kinogluk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/games")
public class GameController {

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    private GameRepository gameRepository;

    @GetMapping
    public String findAll() {
        return "Все игры, содержащиеся в базе: ";
    }

    @GetMapping("/game/title/{gameTitle}")
    public String findByTitle(@PathVariable String gameTitle) {

        return "Игра, которую вы искали: " + gameTitle;
    }


    @PostMapping ("/game/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Game game) {

        return "Игра " + game + " успешно добавлена в библиотеку.";
    }

    @GetMapping("/game/{id}")
    public String delete(@PathVariable Long id) {
        return "Выбранная игра удалена из библиотеки.";
    }

    @GetMapping("/game/{id}/")
    public String ratingUpdate (@RequestBody Game game, @PathVariable Long id) {
        return "Спасибо за Вашу оценку.";
    }
}
