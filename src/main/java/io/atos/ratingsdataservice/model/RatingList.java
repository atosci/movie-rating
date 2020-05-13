package io.atos.ratingsdataservice.model;

import java.util.List;
/**
 * @author Mohamed El Kawakibi
 * @author Puck School
 */
public class RatingList {

    private String movieTitle;
    private List<Rating> ratings;

    /** Gets the title of the movie
     * @return A String representing the movie title
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /** Sets the title of the movie in RatingList.class
     * @param movieTitle A String representing the movie title
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /** Gets the title of the movie
     * @return A List of Rating.class representing the ratings of the movie
     */
    public List<Rating> getRatings() {
        return ratings;
    }

    /** Sets the ratings list for the movie
     * @param ratings A List of Rating.class representing the ratings of the movie
     */
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}

