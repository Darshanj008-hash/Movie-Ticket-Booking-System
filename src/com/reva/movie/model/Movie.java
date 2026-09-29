package com.reva.movie.model;

public class Movie {
    private int id;
    private String title;
    private Genre genre;
    private int durationMinutes;
    private static int movieCount = 0;

    public Movie() {
        this(0, "Untitled", Genre.DRAMA, 0);
    }

    public Movie(int id, String title, Genre genre, int durationMinutes) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.durationMinutes = durationMinutes;
        movieCount++;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }
    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    public static int getMovieCount() { return movieCount; }

    @Override
    public String toString() {
        return String.format("%d | %-20s | %-8s | %d min", id, title, genre, durationMinutes);
    }
}
