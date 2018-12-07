package com.ryan.movie;

public class movieGenre {
    private String genreName;
    private String rating;

    public movieGenre() {
    }

    public movieGenre(String genreName, String rating) {
        this.genreName = genreName;
        this.rating = rating;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

