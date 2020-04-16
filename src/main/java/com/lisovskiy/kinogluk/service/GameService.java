package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.request.GameRequest;

import java.util.List;

public interface GameService {

    Game save (GameRequest request);

    Game edit(int id, GameRequest request);

    void deleteById(int id);

    void deleteByTitle(String title);

    Game findByTitle(String title);

    List<Game> findByRatingBetween(int from, int to);

    List<Game> findAll();

    void deleteAll();

    List<Game> findByReleaseYearBetween(String from, String to);
}
