package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/games")
public class GenreController {

    private final GenreServiceImpl genreService;

    public GenreController (GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    @GetMapping(value = "/genre", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Genre> findAll () {
        return genreService.findAll();
    }

    @GetMapping(value = "/genre/{genreTitle}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Genre findByTitle (@PathVariable("genreTitle") String title) {
        return genreService.findByTitle(title);
    }

    @PostMapping(value = "/genre/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Genre genre) {
        genreService.create(genre);
    }

    @PostMapping(value = "/genre/{genreId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable("genreId") int id) {
        genreService.delete(id);
    }

    @PostMapping(value = "/genre/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByTitle (@RequestBody String title) {
        genreService.deleteByTitle(title);
    }

    @PostMapping(value = "/genre/update/{genreId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update (@PathVariable("genreId") int id, @RequestBody Genre genre) {
        genreService.update(id, genre);
    }
}
