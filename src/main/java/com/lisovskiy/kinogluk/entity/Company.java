package com.lisovskiy.kinogluk.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "companies", schema = "games_db")
public class Company {

    @Id
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Game> games;

    public Company() {
    }

    public Company(String title) {
        this.title = title;
    }

    public List<Game> getGames() {
        return games;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String company) {
        this.title = company;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company1 = (Company) o;
        return companyId == company1.companyId &&
                title.equals(company1.title) &&
                games.equals(company1.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, title, games);
    }
}
