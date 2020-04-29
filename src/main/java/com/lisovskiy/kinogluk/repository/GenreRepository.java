package com.lisovskiy.kinogluk.repository;

import com.lisovskiy.kinogluk.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GenreRepository extends CrudRepository <Genre, Integer> {

    List<Genre> findAll ();
    Genre findByTitle(String title);
    @Transactional
    void deleteByTitle (String title);
}
