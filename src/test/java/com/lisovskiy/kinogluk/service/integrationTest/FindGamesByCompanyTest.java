package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.repository.GameRepository;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import com.lisovskiy.kinogluk.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class FindGamesByCompanyTest {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void findGamesByCompanyTest() {
        Company company = companyService.findByTitle("Guerilla");
        System.out.println(company.getTitle());
        List<Game> games = gameService.findGamesByCompany(company);
        assertEquals(1, games.size());
        System.out.println(games.get(0).getTitle());
    }

}
