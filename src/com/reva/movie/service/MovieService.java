package com.reva.movie.service;

import com.reva.movie.model.Genre;
import com.reva.movie.model.Movie;

public class MovieService {
    private static final int MAX_MOVIES = 10;
    private final Movie[] movies = new Movie[MAX_MOVIES];
    private int movieCount = 0;

    public MovieService() {
        addMovie(new Movie(101, "Sky Warriors", Genre.ACTION, 145));
        addMovie(new Movie(102, "Laugh Out Loud", Genre.COMEDY, 120));
        addMovie(new Movie(103, "The Last Signal", Genre.THRILLER, 132));
        addMovie(new Movie(104, "Future Earth", Genre.SCI_FI, 150));
    }

    public boolean addMovie(Movie movie) {
        if (movieCount >= MAX_MOVIES) return false;
        movies[movieCount++] = movie;
        return true;
    }

    public void listMovies() {
        System.out.println("\nID   | Title                | Genre    | Duration");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < movieCount; i++) {
            System.out.println(movies[i]);
        }
    }

    public Movie findMovie(int id) {
        for (int i = 0; i < movieCount; i++) {
            if (movies[i].getId() == id) return movies[i];
        }
        return null;
    }

    public Movie findMovie(String title) {
        String query = title.trim().toLowerCase();
        for (int i = 0; i < movieCount; i++) {
            if (movies[i].getTitle().toLowerCase().contains(query)) return movies[i];
        }
        return null;
    }

    public int getMovieCount() { return movieCount; }
}
