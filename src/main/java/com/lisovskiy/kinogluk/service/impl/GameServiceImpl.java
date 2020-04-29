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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @PersistenceContext
    EntityManager entityManager;

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional
    public Game create(Game game) {
        entityManager.persist(game);
        return game;
    }

    @Transactional
    public void delete(int id) {
        Game game = entityManager.find(Game.class, id);
        if (game != null) {
            entityManager.remove(game);
        } else throw new GameNotFoundException(id);
    }

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

    @Transactional
    public Game update(int id, Game game) {
        Game original = entityManager.find(Game.class, id);
        if (original != null) {
            original.setTitle(game.getTitle());
            original.setRating(game.getRating());
            original.setReleaseYear(game.getReleaseYear());
            original.setShortDescription(game.getShortDescription());
            entityManager.merge(original);
        }

        return original;
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
