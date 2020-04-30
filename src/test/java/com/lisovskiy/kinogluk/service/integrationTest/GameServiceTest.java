package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GameServiceTest {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    CatalogServiceImpl catalogService;

    @Autowired
    GenreServiceImpl genreService;

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void create() {

        Catalog catalog = new Catalog();
        catalog.setTitle("playing");

        Genre genre = new Genre();
        genre.setTitle("Card battle");
        List<Genre> genres = new ArrayList<>();
        genres.add(genre);

        Company company = new Company();
        company.setTitle("Blizzard");

        Game game = new Game();
        game.setShortDescription("Collection card game");
        game.setRating(8);
        game.setReleaseYear(LocalDate.of(2013, 4, 15));
        game.setTitle("NHL");
        game.setCatalog(catalog);
        game.setCompany(company);
        List<Game> games = new ArrayList<>();
        games.add(game);

        game.setGenres(genres);
        System.out.println(genre.getTitle());
        genre.setGames(games);

        gameService.create(game);

        assertEquals(game.getTitle(), (gameService.findByTitle(game.getTitle()).getTitle()));
    }

    @Test
    public void findAll() {
        List<Game> games = gameService.findAll();
        assertEquals(games.size(), gameService.findAll().size());
    }

    @Test
    public void update() {
        Catalog catalog = new Catalog();
        catalog.setTitle("Best RPG games");

        Company company = new Company();
        company.setTitle("cd red project");

        Genre genre = new Genre();
        genre.setTitle("rpg");
        System.out.println(genre.getTitle());
        List<Genre> genres = new ArrayList<>();
        genres.add(genre);

        Game game = new Game();
        game.setShortDescription("BEST RPG IN the WORLD");
        game.setRating(10);
        game.setReleaseYear(LocalDate.of(2010, 2, 6));
        game.setTitle("Witcher 3");
        catalogService.update(catalogService.findAll().get(0).getCatalogId(), catalog);
        companyService.update(companyService.findAll().get(0).getCompanyId(), company);
        game.setCatalog(catalog);
        game.setCompany(company);

        List<Game> games = new ArrayList<>();
        games.add(game);

        game.setGenres(genres);
        System.out.println(genre.getTitle());
        genre.setGames(games);

        genreService.update(genreService.findAll().get(0).getId(), genre);

        gameService.update(gameService.findAll().get(0).getId(), game);
    }

    @Test
    public void delete() {
        create();
        int result = gameService.findAll().size();
        gameService.delete(gameService.findAll().get(0).getId());
        assertEquals(result-1, gameService.findAll().size());
    }

    @Test
    public void deleteByTitleTest() {
        int result = gameService.findAll().size();
        gameService.deleteByTitle(gameService.findAll().get(2).getTitle());
        assertEquals(result-1, gameService.findAll().size());
    }

    @Test
    public void findGamesByCatalog() {
        Catalog catalog = catalogService.findByTitle("playing");
        List<Game> games = gameService.findGamesByCatalog(catalog);
        assertEquals(1, games.size());
        System.out.println(games.get(0).getTitle());
    }

    @Test
    public void findGamesByCompanyTest() {
        Company company = companyService.findByTitle("Blizzard");
        List<Game> games = gameService.findGamesByCompany(company);
        assertEquals(1, games.size());
        System.out.println(games.get(0).getTitle());
    }

    @Test
    public void findGamesByGenreTest() {
        Genre genre = genreService.findByTitle("rpg");
        List<Game> games = gameService.findGamesByGenre(genre);
        assertEquals(1, games.size());
        System.out.println(games.get(0).getTitle());
    }

    @Test
    public void finByRatingBetweenTest() {
        List<Game> games = gameService.findByRatingBetween(7, 9);
        assertEquals(1, games.size());
    }

    @Test
    public void findByReleaseYearBetween() {
        List<Game> games = gameService.findByReleaseYearBetween("2010-01-01", "2010-12-12");
        assertEquals(1, games.size());
        System.out.println(games.get(0).getTitle());
    }

}
