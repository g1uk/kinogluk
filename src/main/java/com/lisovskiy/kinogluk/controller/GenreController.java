package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/games")
public class GenreController {

    private final GenreServiceImpl genreService;

    public GenreController (GenreServiceImpl genreService) {this.genreService = genreService;}

    @GetMapping("/genre")
    public List<Genre> findAll () {return genreService.findAll();}

    @GetMapping("/genre/{genreTitle}")
    public Genre findByTitle (@PathVariable("genreTitle") String title) {
        return genreService.findByTitle(title);
    }

    @PostMapping("/genre/{genreId")
    public Genre add (@RequestBody Genre genre) {return genreService.save(genre);}
}
