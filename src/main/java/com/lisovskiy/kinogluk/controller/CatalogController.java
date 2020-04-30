package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/games")
public class CatalogController {

    private final CatalogServiceImpl catalogService;

    public CatalogController(CatalogServiceImpl catalogService) {
        this.catalogService = catalogService;
    }

    //public CatalogController() {}

    @GetMapping(value = "/catalog", produces = MediaType.APPLICATION_JSON_VALUE)//, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Catalog>> findAll () {
        return ResponseEntity.ok(catalogService.findAll());
    }

    @GetMapping("/catalog/{catalogTitle}")
    public Catalog findByTitle (@PathVariable("catalogTitle") String title) {
        return catalogService.findByTitle(title);
    }

    @PostMapping("/catalog/update/{catalogId}")
    public Catalog update (@PathVariable("catalogId") int id, @RequestBody Catalog catalog) {
        return catalogService.update(id, catalog);
    }

    @PostMapping(value = "/catalog/{catalogId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable("catalogId") int id) {
        catalogService.delete(id);
    }

    @PostMapping(value = "/catalog/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByTitle (@RequestBody String title) {
        catalogService.deleteByTitle(title);
    }

    @PostMapping(value = "/catalog/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Catalog create (@RequestBody Catalog catalog) {
        return catalogService.create(catalog);
    }
}
