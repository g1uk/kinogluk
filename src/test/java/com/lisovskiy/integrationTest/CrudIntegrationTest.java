package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Game;
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

import java.util.List;


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
    public void test() {
        List<Game> byRating = gameService.findByRating(2, 7);
        byRating.forEach(game -> System.out.println(game.getTitle() + " " + game.getRating()));
    }

}
