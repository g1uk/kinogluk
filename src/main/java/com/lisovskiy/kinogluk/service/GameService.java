package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Game;

import java.util.List;

public interface GameService {

    Game save(Game game);
    void deleteById(int id);

    Game findByTitle(String title);

    Game edit (Game game);
    List<Game> findAll();
}
