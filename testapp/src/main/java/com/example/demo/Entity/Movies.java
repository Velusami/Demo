package com.example.demo.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movies {
    private String movieName;
    private int releaseYear;
    private String director;

    public Movies(String movieName, int releaseYear, String director) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.director = director;
    }
}
