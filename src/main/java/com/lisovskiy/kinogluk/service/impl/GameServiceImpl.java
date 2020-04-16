package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.exceptions.GameNotFoundException;
import com.lisovskiy.kinogluk.repository.GameRepository;
import com.lisovskiy.kinogluk.request.GameRequest;
import com.lisovskiy.kinogluk.service.GameService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game save(GameRequest request) {
        Game game = new Game();
        game.setTitle(request.getTitle());
        game.setRating(request.getRating());
        game.setReleaseYear(request.getReleaseYear());
        game.setShortDescription(request.getShortDescription());
        return gameRepository.save(game);
    }

    @Override
    public Game edit (int id, GameRequest request) {
        if (gameRepository.existsById(id)) {
            throw new GameNotFoundException(id);
        }
        Game game = new Game();
        game.setGameId(id);
        game.setTitle(request.getTitle());
        game.setRating(request.getRating());
        game.setReleaseYear(request.getReleaseYear());
        game.setShortDescription(request.getShortDescription());
        return gameRepository.save(game);
    }

    @Override
    public void deleteById(int id) {
        if (!gameRepository.existsById(id)) {
            throw new GameNotFoundException(id);
        }
        gameRepository.deleteById(id); }

    @Override
    public void deleteByTitle(String title) {
        gameRepository.deleteByTitle(title);
    }

    @Override
    public Game findByTitle(String title) {
        Game game = gameRepository.findByTitle(title);
        if (game == null) {
            throw new GameNotFoundException(title);
        }
        return game;
    }

    @Override
    public List<Game> findByRatingBetween(int from, int to) {
        List<Game> games = gameRepository.findByRatingBetween(from, to);
        if (games.size() == 0) {
            throw new GameNotFoundException(from, to);
        }
        return games;
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void deleteAll() { gameRepository.deleteAll(); };

    @Override
    public List<Game> findByReleaseYearBetween(String from, String to) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateFrom = LocalDate.parse(from, formatter.withResolverStyle(ResolverStyle.SMART));
        LocalDate dateTo = LocalDate.parse(to, formatter.withResolverStyle(ResolverStyle.SMART));

        if (dateTo == null || dateFrom == null) {
            throw new GameNotFoundException(from, to);
        }
        return gameRepository.findByReleaseYearBetween(dateFrom, dateTo);
    }



}
