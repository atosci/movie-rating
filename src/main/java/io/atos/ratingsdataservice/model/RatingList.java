package io.atos.ratingsdataservice.model;

import java.util.List;

public class RatingList {

    private String movieTitle;
    private List<Rating> ratings;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}

