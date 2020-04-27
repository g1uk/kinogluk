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
        catalog.setTitle("played");
        catalogService.save(catalog);

        Genre genre = new Genre();
        genre.setTitle("test genre22");
        genreService.save(genre);
        System.out.println(genre.getTitle());
        List<Genre> genres = new ArrayList<>();
        genres.add(genre);

        Company company = new Company();
        company.setTitle("test company");
        companyService.save(company);

        Game game = new Game();
        game.setShortDescription("test descriptionsefh");
        game.setRating(2);
        game.setReleaseYear(LocalDate.of(2000, 1, 1));
        game.setTitle("test game");
        game.setCatalog(catalog);
        game.setCompany(company);
        List<Game> games = new ArrayList<>();
        games.add(game);

        game.setGenres(genres);
        System.out.println(genre.getTitle());
        genre.setGames(games);

        genreService.create(genre);
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
        //catalogService.save(catalog);

        Genre genre = new Genre();
        genre.setTitle("rpg");
        //genreService.save(genre);
        System.out.println(genre.getTitle());
        List<Genre> genres = new ArrayList<>();
        genres.add(genre);

        Company company = new Company();
        company.setTitle("cd red project");
        //companyService.save(company);

        Game game = new Game();
        game.setShortDescription("BEST RPG IN the WORLD");
        game.setRating(10);
        game.setReleaseYear(LocalDate.of(2010, 2, 6));
        game.setTitle("Witcher 3");
        catalogService.update(catalogService.findAll().get(4).getCatalogId(), catalog);
        companyService.update(companyService.findAll().get(4).getCompanyId(), company);
        game.setCatalog(catalog);
        game.setCompany(company);
        List<Game> games = new ArrayList<>();
        games.add(game);

        game.setGenres(genres);
        System.out.println(genre.getTitle());
        genre.setGames(games);
        //genreService.save(genre);




        genreService.update(genreService.findAll().get(4).getId(), genre);

        gameService.update(gameService.findAll().get(4).getId(), game);

        //assertEquals(game.getTitle(), gameService.edit(allGames.get(0).getId(), game).getTitle());
//        assertEquals(company.getTitle(), companyService.update(companyService.findAll().get(0).getCompanyId(), company).getTitle());
//        assertEquals(catalog.getTitle(), catalogService.update(catalogService.findAll().get(0).getCatalogId(), catalog).getTitle());
//        assertEquals(genre.getTitle(), genreService.update(genreService.findAll().get(0).getId(), genre).getTitle());

    }

    @Test
    public void delete() {
        //create();
        int result = gameService.findAll().size();
        gameService.deleteById(gameService.findAll().get(4).getId());
        assertEquals(result-1, gameService.findAll().size());
    }

}
