package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.entity.Genre;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GameService {

    Game findByTitle(String title);

    Game update(int id, Game game);

    List<Game> findByRatingBetween(int from, int to);
    List<Game> findGamesByCompany(Company company);
    List<Game> findGamesByCatalog(Catalog catalog);
    List<Game> findGamesByGenre(Genre genre);
    List<Game> findByReleaseYearBetween(String from, String to);
    List<Game> findAll();

    @Transactional
    void deleteByTitle(String title);



}
