package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CatalogServiceTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void create() {
        Catalog catalog = new Catalog();
        catalog.setTitle("Want to play");
        catalogService.create(catalog);
        assertEquals(catalog.getTitle(), catalogService.findByTitle(catalog.getTitle()).getTitle());
    }

    @Test
    public void findAll() {
        List<Catalog> catalogs = catalogService.findAll();
        assertEquals(catalogs.size(), catalogService.findAll().size());
    }

    @Test
    public void update() {
        Catalog catalog = new Catalog();
        catalog.setTitle("Games");
        catalogService.create(catalog);
        Catalog original = new Catalog();
        original.setTitle("My Games");
        assertEquals(original.getTitle(), (catalogService.update(catalog.getCatalogId(), original).getTitle()));
    }

    @Test
    public void delete() {
        Catalog catalog = new Catalog();
        catalog.setTitle("Test catalog");
        catalogService.create(catalog);
        int result = catalogService.findAll().size();
        catalogService.delete(catalog.getCatalogId());
        assertEquals(result-1, catalogService.findAll().size());
    }

    @Test
    public void deleteByTitle() {
        Catalog catalog = new Catalog();
        catalog.setTitle("Test catalog");
        catalogService.create(catalog);
        int result = catalogService.findAll().size();
        catalogService.deleteByTitle(catalog.getTitle());
        assertEquals(result-1, catalogService.findAll().size());

    }

    @Test
    public void findByTitle() {
        Catalog catalog = new Catalog();
        catalog.setTitle("famous");
        catalogService.create(catalog);
        assertEquals(catalog.getTitle(), catalogService.findByTitle(catalog.getTitle()).getTitle());

    }



}
