package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.request.CatalogRequest;
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

    @GetMapping("/catalogs")
    public List<Catalog> findAll () {return catalogService.findAll();}

    @PostMapping("/catalog")
    @ResponseStatus(HttpStatus.CREATED)
    public Catalog add (@RequestBody CatalogRequest request) {
        return catalogService.save(request);
    }

    @PostMapping("/catalog/{catalogId}")
    public Catalog edit(@PathVariable("catalogId") int id, @RequestBody CatalogRequest request) {
        return catalogService.edit(id, request);
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
