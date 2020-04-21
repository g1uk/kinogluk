package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CatalogDeleteByTitleTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void deleteByTitleTest() {
        List<Catalog> catalogs = catalogService.findAll();
        catalogService.deleteByTitle(catalogs.get(1).getTitle());
        assertEquals(catalogs.size()-1, catalogService.findAll().size());

    }

}
