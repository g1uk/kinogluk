package com.lisovskiy.kinogluk.repository;

import com.lisovskiy.kinogluk.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends CrudRepository <Genre, Long> {

    List<Genre> findAll ();
    Genre save (Genre genre);
    Genre findByTitle(String title);
}
