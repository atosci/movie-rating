package io.atos.ratingsdataservice.model;

import io.atos.ratingsdataservice.PojoTestUtils;
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
