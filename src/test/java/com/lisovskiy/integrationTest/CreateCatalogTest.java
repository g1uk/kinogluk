package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = KinoglukApplication.class)
public class CreateCatalogTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void createTest() {
        Catalog catalog = new Catalog();
        catalog.setTitle("The Best");
    }

}
