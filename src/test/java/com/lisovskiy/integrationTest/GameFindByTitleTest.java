package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.request.GameRequest;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class GameFindByTitleTest {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    CatalogServiceImpl catalogService;

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void findByTitleTest() {
        GameRequest request = new GameRequest();
        request.setShortDescription("Test Description");
        request.setRating(8);
        request.setReleaseYear(LocalDate.of(1980, 05, 20));
        request.setTitle("New Game3");
        request.setCompany(companyService.findByTitle("New Test Company"));
        request.setCatalog(catalogService.findByTitle("New Test Catalog"));
        gameService.save(request);
        assertEquals(request.getTitle(), (gameService.findByTitle(request.getTitle()).getTitle()));
    }
}
