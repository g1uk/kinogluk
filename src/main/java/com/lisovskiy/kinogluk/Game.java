package com.lisovskiy.kinogluk;

import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int rating;

    @Column (nullable = false, unique = true)
    private String short_description;



    @Column (nullable = false, unique = true)
    private String title;

    public Game(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
