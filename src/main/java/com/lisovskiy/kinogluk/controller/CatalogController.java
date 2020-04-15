package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/games")
public class CatalogController {

    private final CatalogServiceImpl catalogService;

    public CatalogController(CatalogServiceImpl catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/catalog")
    public List<Catalog> findAll () {return catalogService.findAll();}

    @PostMapping("/catalog/{catalogId}")
    public Catalog add (@RequestBody Catalog catalog) {
        return catalogService.save(catalog);
    }

    @GetMapping("/catalog/{catalogTitle}")
    public Catalog findByTitle (@PathVariable("catalogTitle") String title) {
        return catalogService.findByTitle(title);
    }

    @PostMapping("/catalog/delete/{catalogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable("catalogId") int id) {
        catalogService.deleteById(id);
    }
}
