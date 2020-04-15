package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CatalogFindByTitleTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void findByTitleTest() {
        Catalog catalog = new Catalog();
        catalog.setTitle("New Catalog4");
        catalogService.save(catalog);
        assertEquals(catalog.getTitle(), catalogService.findByTitle(catalog.getTitle()).getTitle());
    }
}
