package io.javabrains.ratingsdataservice.model;

import io.javabrains.ratingsdataservice.PojoTestUtils;
import org.junit.Assert;
import org.junit.Test;

public class RatingListTests {

    @Test
    public void validateUserRatingGettersSettersTest() {
        PojoTestUtils.ValidateAccessors(RatingList.class);
    }

    @Test
    public void validateGetMovieTitle() {
        String movieTitle = "Scary movie";

        RatingList ratingList = new RatingList();
        ratingList.setMovieTitle(movieTitle);

        Assert.assertEquals(movieTitle, ratingList.getMovieTitle());
    }
}
