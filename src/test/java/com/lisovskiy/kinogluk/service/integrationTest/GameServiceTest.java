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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        catalog.setTitle("Favourite");
        catalogService.save(catalog);

        Genre genre = new Genre();
        genre.setTitle("RPG");
        genreService.save(genre);
        System.out.println(genre.getTitle());
        Set<Genre> genres = new HashSet<>();
        genres.add(genre);

        Company company = new Company();
        company.setTitle("Guerilla");
        companyService.save(company);

        Game game = new Game();
        game.setShortDescription("the best game on PS");
        game.setRating(10);
        game.setReleaseYear(LocalDate.of(2017, 11, 16));
        game.setTitle("Horizon Zero Dawn");
        game.setCatalog(catalog);
        game.setCompany(company);
        Set<Game> games = new HashSet<>();
        games.add(game);

        game.setGenres(genres);
        System.out.println(genre.getTitle());
        genre.setGames(games);

        genreService.create(genre);
        gameService.create(game);

        assertEquals(game.getTitle(), (gameService.findByTitle(game.getTitle()).getTitle()));

//        catalogService.delete(catalog.getCatalogId());
//        genreService.deleteById(genre.getId());
//        companyService.delete(company.getCompanyId());
//        gameService.deleteById(game.getId());

        //assertThrows(GameNotFoundException.class, () -> gameService.findByTitle(game.getTitle()));
    }

    @Test
    public void findAll() {
        List<Game> games = gameService.findAll();
        assertEquals(games.size(), gameService.findAll().size());
    }

    @Test
    public void update() {
        Game game = new Game();
        game.setTitle("Test title");
        game.setRating(8);
        game.setReleaseYear(LocalDate.of(2000,12,12));
        game.setShortDescription("short");
        gameService.save(game);
        Game original = new Game();
        original.setTitle("Horizon Zero Dawn");
        original.setRating(10);
        original.setReleaseYear(LocalDate.of(2017, 10, 20));
        original.setShortDescription("My favourite game");
        assertEquals(original.getTitle(), gameService.edit(game.getId(), original).getTitle());
    }

    @Test
    public void delete() {
        Game game = new Game();
        game.setTitle("Test");
        game.setRating(8);
        game.setReleaseYear(LocalDate.of(2000,12,12));
        game.setShortDescription("aFEFAQWE");
        gameService.save(game);
        int result = gameService.findAll().size();
        gameService.deleteById(game.getId());
        assertEquals(result-1, gameService.findAll().size());
    }

}
