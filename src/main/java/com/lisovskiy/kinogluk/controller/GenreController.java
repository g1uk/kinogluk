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

    @PostMapping("/genre/{genreId")
    public Genre add (@RequestBody Genre genre) {return genreService.save(genre);}

    @PostMapping(value = "/genre/delete/{genreId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable("genreId") int id) {
        genreService.deleteById(id);
    }

    @PostMapping(value = "/genre/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByTitle (@RequestBody String title) {
        genreService.deleteByTitle(title);
    }
}
