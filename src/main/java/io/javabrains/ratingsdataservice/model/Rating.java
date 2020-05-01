package io.javabrains.ratingsdataservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {

    @JsonProperty("Source")
    private String source;

    @JsonProperty("Value")
    private String rating;

    // default constructor
    public Rating() {
    }

    public Rating(String source, String rating) {
        this.source = source;
        this.rating = rating;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
