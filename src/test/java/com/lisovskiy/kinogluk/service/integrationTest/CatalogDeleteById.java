package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CatalogDeleteById {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void deleteByIdTest() {
        List<Catalog> catalogs = catalogService.findAll();
        catalogService.deleteById(catalogs.get(1).getCatalogId());
        assertEquals(catalogs.size()-1, catalogService.findAll().size());
    }
}
