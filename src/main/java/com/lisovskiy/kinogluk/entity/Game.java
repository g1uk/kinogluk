package com.lisovskiy.kinogluk.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "game", schema = "games_db")
public class Game {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Max(10)
    @PositiveOrZero
    @Column (name = "rating")
    private int rating;

    @NotNull
    @Column (name = "short_description", unique = true)
    private String shortDescription;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column (name = "release_year")
    private LocalDate releaseYear;

    @NotNull
    @Size(min = 2, max = 45)
    @Column (name = "title")
    private String title;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "catalogs_id")
    private Catalog catalog;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "game_genre",
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))

    @Nullable
    private List<Genre> genres;

    @Nullable
    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Game() {
    }

    public Game(int rating, String shortDescription, LocalDate releaseYear, String title) {
        this.rating = rating;
        this.shortDescription = shortDescription;
        this.releaseYear = releaseYear;
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Game game = (Game) o;
        return id == game.id &&
                rating == game.rating &&
                shortDescription.equals(game.shortDescription) &&
                releaseYear.equals(game.releaseYear) &&
                title.equals(game.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, shortDescription, releaseYear, title);
    }
}
