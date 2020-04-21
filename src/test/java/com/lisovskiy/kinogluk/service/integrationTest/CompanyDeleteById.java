package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CompanyDeleteById {

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void deleteByIdTest() {
        List<Company> companies = companyService.findAll();
        companyService.deleteById(companies.get(1).getCompanyId());
        assertEquals(companies.size()-1, (companyService.findAll().size()));
    }
}
