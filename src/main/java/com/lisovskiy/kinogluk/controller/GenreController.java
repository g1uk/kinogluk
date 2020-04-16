package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Genre;
import com.lisovskiy.kinogluk.request.GenreRequest;
import com.lisovskiy.kinogluk.service.impl.GenreServiceImpl;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/genre")
    @ResponseStatus(HttpStatus.CREATED)
    public Genre add (@RequestBody GenreRequest request) {return genreService.save(request);}

    @PostMapping("/genre/{genreId}")
    public Genre edit (@PathVariable("genreId") int id, @RequestBody GenreRequest request) {
        return genreService.edit(id, request);
    }

    @PostMapping("/genre/delete/{genreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable("genreId") int id) {
        genreService.deleteById(id);
    }
}
