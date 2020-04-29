package com.lisovskiy.kinogluk.repository;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    Game findByTitle(String title);

    List<Game> findAll();

    List<Game> findByRatingBetween(int from, int to);

    List<Game> findByReleaseYearBetween(LocalDate from, LocalDate to);

    @Transactional
    void deleteByTitle(String title);

    List<Game> findGamesByCompany(Company company);

    List<Game> findGamesByCatalog(Catalog catalog);

    List<Game> findGamesByGenres(Genre genre);

}
