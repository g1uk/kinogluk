package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CompanyDeleteByTitleTest {

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void deleteByTitleTest() {
        List<Company> companies = companyService.findAll();
        companyService.deleteByTitle(companies.get(0).getTitle());
        assertEquals(companies.size()-1, companyService.findAll().size());
    }

}
