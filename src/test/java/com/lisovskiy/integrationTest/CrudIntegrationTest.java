package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.repository.CatalogRepository;
import com.lisovskiy.kinogluk.repository.CompanyRepository;
import com.lisovskiy.kinogluk.repository.GameRepository;
import com.lisovskiy.kinogluk.repository.GenreRepository;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = KinoglukApplication.class)
public class CrudIntegrationTest {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    CatalogRepository catalogRepository;

    @Autowired
    CatalogServiceImpl catalogService;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyServiceImpl companyService;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    GenreServiceImpl genreService;

    @Test
    public void CrudTestCatalog() {
        catalogRepository.deleteAll();
        Catalog catalog = new Catalog();
        catalog.setTitle("Test Catalog");
        catalogService.save(catalog);
        catalog.setTitle("UpdateTest Catalog");
        catalogService.save(catalog);
        List<Catalog> catalogs = catalogService.findAll();
        assertEquals(1, catalogs.size());
        System.out.println(catalogs.get(0).getTitle());

    }

    @Test
    public void CrudTestCompany() {
        companyRepository.deleteAll();
        Company company = new Company();
        company.setTitle("Test Company");
        companyService.save(company);
        company.setTitle("UpdateTest Company");
        companyService.save(company);
        List<Company> companies = companyService.findAll();
        assertEquals(1, companies.size());
        System.out.println(companies.get(0).getTitle());
    }

    @Test
    public void CrudTestGenre() {
        genreRepository.deleteAll();
        Genre genre = new Genre();
        genre.setTitle("Test Genre");
        genreService.save(genre);
        genre.setTitle("UpdateTest Genre");
        genreService.save(genre);
        List<Genre> genres = genreService.findAll();
        assertEquals(1, genres.size());
        System.out.println(genres.get(0).getTitle());
    }

    @Test
    public void CrudTestGame() {
        gameRepository.deleteAll();
        Game game = new Game();
        game.setTitle("Test Game");
        game.setReleaseYear(new Date());
        game.setRating(8);
        game.setShortDescription("Test Description");
        game.setCatalog(catalogService.findByTitle("UpdateTest Catalog"));
        game.setCompany(companyService.findByTitle("UpdateTest Company"));
        gameService.save(game);
        game.setTitle("UpdateTest Game");
        gameService.save(game);
        List<Game> games = gameService.findAll();
        assertEquals(1, games.size());
        System.out.println(games.get(0).getTitle());
    }



}
