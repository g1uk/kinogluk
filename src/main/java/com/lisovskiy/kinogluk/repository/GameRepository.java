package com.lisovskiy.kinogluk.repository;

import com.lisovskiy.kinogluk.entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    Game save(Game game);

    void deleteById (int id);

    Game findByTitle(String title);

    List<Game> findAll();

    List<Game> findByRatingBetween(int from, int to);

    List<Game> findByReleaseYearBetween(LocalDate from, LocalDate to);

    void deleteByTitle(String title);

}
