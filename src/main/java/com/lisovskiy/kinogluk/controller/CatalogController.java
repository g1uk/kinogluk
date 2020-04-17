package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.request.CatalogRequest;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/games")
public class CatalogController {

    private final CatalogServiceImpl catalogService;

    public CatalogController(CatalogServiceImpl catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/catalogs")
    public List<Catalog> findAll () {
        return catalogService.findAll();
    }

    @PostMapping(value = "/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Catalog add (@RequestBody CatalogRequest request) {
        return catalogService.save(request);
    }

    @PostMapping(value = "/catalog/{catalogId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Catalog edit(@PathVariable("catalogId") int id, @RequestBody CatalogRequest request) {
        return catalogService.edit(id, request);
    }

    @GetMapping("/catalog/{catalogTitle}")
    public Catalog findByTitle (@PathVariable("catalogTitle") String title) {
        return catalogService.findByTitle(title);
    }

    @PostMapping(value = "/catalog/delete/{catalogId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable("catalogId") int id) {
        catalogService.deleteById(id);
    }

    @PostMapping(value = "/catalog/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByTitle (@RequestBody String title) {
        catalogService.deleteByTitle(title);
    }

    @PostMapping(value = "/catalog/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Catalog create (@RequestBody Catalog catalog) {
        return catalogService.create(catalog);
    }
}
