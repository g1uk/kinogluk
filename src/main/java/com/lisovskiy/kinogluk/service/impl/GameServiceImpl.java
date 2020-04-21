package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.exceptions.*;
import com.lisovskiy.kinogluk.repository.GameRepository;
import com.lisovskiy.kinogluk.service.GameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Game save (Game game) { return gameRepository.save(game); }

    @Override
    public void deleteById(int id) {
        if (!gameRepository.existsById(id)) {
            throw new GameNotFoundException(id);
        }
        gameRepository.deleteById(id); }

    @Override
    @Transactional
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
    public Game edit(int id, Game game) {
        if (!gameRepository.existsById(id)) {
            throw new GameNotFoundException(id);
        }
        game.setGameId(id);
        game.setTitle(game.getTitle());
        return gameRepository.save(game);
    }

    @Override
    public List<Game> findByRatingBetween(int from, int to) {
        List<Game> games = gameRepository.findByRatingBetween(from, to);
        if (games.size() == 0) {
            throw new GameWithRatingNotFoundException(from, to);
        }
        return games;
    }

    @Override
    public List<Game> findGamesByCompany(Company company) {
        List<Game> games = gameRepository.findGamesByCompany(company);
        if (games.size() == 0) {
            throw new GameOfCompanyNotFoundException(company);
        }
        return games;
    }

    @Override
    public List<Game> findGamesByCatalog(Catalog catalog) {
        List<Game> games = gameRepository.findGamesByCatalog(catalog);
        if (games.size() == 0) {
            throw new GameOfCatalogNotFoundException(catalog);
        }
        return games;
    }

    @Override
    public List<Game> findGamesByGenre(Genre genre) {
        List<Game> games = gameRepository.findGamesByGenres(genre);
        if (games.size() == 0) {
            throw new GameOfGenreNotFoundException(genre);
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
            throw new GameOfReleaseYearNotFoundException(from, to);
        }
        return gameRepository.findByReleaseYearBetween(dateFrom, dateTo);
    }



}
