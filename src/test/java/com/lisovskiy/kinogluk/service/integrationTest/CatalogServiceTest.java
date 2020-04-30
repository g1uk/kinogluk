package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.exceptions.CatalogNotFoundException;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CatalogServiceTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void create() {
        String title = "favourite";
        Catalog catalog = new Catalog();
        catalog.setTitle(title);
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
        String title = "Test catalog";
        String newTitle = "My games";
        Catalog catalog = new Catalog();
        catalog.setTitle(title);
        catalogService.create(catalog);
        Catalog original = new Catalog();
        original.setTitle(newTitle);
        assertEquals(original.getTitle(), (catalogService.update(catalog.getCatalogId(), original).getTitle()));
    }

    @Test
    public void delete() {
        String title = "Test catalog";
        Catalog catalog = new Catalog();
        catalog.setTitle("Test catalog");
        catalogService.create(catalog);
        int catalogId = catalog.getCatalogId();
        Catalog insertedCatalog = catalogService.findByTitle(title);
        assertNotNull(insertedCatalog);
        catalogService.delete(catalogId);
        assertThrows(CatalogNotFoundException.class, () -> {
           catalogService.findByTitle(title);
        });
    }

    @Test
    public void deleteByTitle() {
        String title = "Test catalog";
        Catalog catalog = new Catalog();
        catalog.setTitle(title);
        catalogService.create(catalog);
        Catalog insertedCatalog = catalogService.findByTitle(title);
        assertNotNull(insertedCatalog);
        catalogService.deleteByTitle(title);
        assertThrows(CatalogNotFoundException.class, () -> {
           catalogService.findByTitle(title);
        });
    }

    @Test
    public void findByTitle() {
        Catalog catalog = new Catalog();
        catalog.setTitle("famous");
        catalogService.create(catalog);
        assertEquals(catalog.getTitle(), catalogService.findByTitle(catalog.getTitle()).getTitle());

    }



}
