package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.exceptions.GameNotFoundException;
import com.lisovskiy.kinogluk.repository.GameRepository;
import com.lisovskiy.kinogluk.service.GameService;
import org.springframework.stereotype.Service;

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
    public void deleteById(int id) { gameRepository.deleteById(id); }

    @Override
    public Game findByTitle(String title) {
        Game game = gameRepository.findByTitle(title);
        if (game == null) {
            throw new GameNotFoundException(title);
        }
        return game;
    }

    @Override
    public Game edit(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }





}
