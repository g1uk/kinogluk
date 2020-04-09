package com.lisovskiy.kinogluk.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "game", schema = "games_db")
public class Game {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int gameId;

    @Column (name = "rating")
    private int rating;

    @Column (name = "short_description", nullable = false, unique = true)
    private String shortDescription;

    @Column (name = "release_year", nullable = false)
    private Date releaseYear;

    @Column (name = "title", nullable = false, unique = true)
    private String title;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToOne
    @JoinColumn(name = "catalogs_id", nullable = false)
    private Catalog catalog;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @ManyToMany
    @JoinTable(name = "genre",
                joinColumns = @JoinColumn(name = "game_id"),
                inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Game() {
    }

    public Game(int rating, String shortDescription, Date releaseYear, String title) {
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

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }


    public int getGameId() { return gameId; }

    public void setGameId(int gameId) {
        this.gameId = gameId;
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
        return gameId == game.gameId &&
                rating == game.rating &&
                shortDescription.equals(game.shortDescription) &&
                releaseYear.equals(game.releaseYear) &&
                title.equals(game.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, rating, shortDescription, releaseYear, title);
    }
}
