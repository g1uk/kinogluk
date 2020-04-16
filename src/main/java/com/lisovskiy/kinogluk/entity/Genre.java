package com.lisovskiy.kinogluk.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "genre", schema = "games_db")
public class Genre {
    @Id
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int genreId;

    @Basic
    @NotNull
    @Column(name = "title", length = 45)
    private String title;

    @ManyToMany(mappedBy = "genres")
    private List<Game> games;

    public Genre() {
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Genre(String title) {
        this.title = title;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre that = (Genre) o;

        if (genreId != that.genreId) return false;
        if (!Objects.equals(title, that.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = genreId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
