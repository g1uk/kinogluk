package com.lisovskiy.kinogluk.repository;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    Game save(Game game);

    void deleteById (int id);

    Game findByTitle(String title);

    List<Game> findAll();

    List<Game> findAllByRatingBetween(int from, int to);

    void deleteGamesByCompany();

    void deleteGamesByCompany(Company company);
}
