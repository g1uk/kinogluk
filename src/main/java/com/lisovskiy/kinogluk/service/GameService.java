package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Game;

import java.util.List;

public interface GameService {

    Game save(Game game);

    void deleteById(int id);

    Game findByTitle(String title);

    Game edit(int id, Game game);

    List<Game> findByRatingBetween(int from, int to);

    List<Game> findAll();

    void deleteAll();
}
