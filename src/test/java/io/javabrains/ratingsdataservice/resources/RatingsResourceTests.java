package io.javabrains.ratingsdataservice.resources;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.RatingList;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class RatingsResourceTests {

    private static final Rating rating1 = new Rating("IMDB", "10/10");
    private static final Rating rating2 = new Rating("New York Times", "8.5");
    private static final String movieTitle1 = "Titanic";
    private static RatingList ratingList1 = new RatingList();
    private RatingsResource ratingsResource;

    @BeforeEach
    public void init() {
        ratingList1.setMovieTitle(movieTitle1);
        ratingList1.setRatings(Arrays.asList(rating1, rating2));

        ratingsResource = new RatingsResource();
    }

    @Test
    public void testCorrectGetMovieRating() {
        String value = "5"; // default value for GetMovieRating()

        RatingsResource ratingsResource = new RatingsResource();
        Rating expected = ratingsResource.getMovieRating(movieTitle1);
        Assert.assertEquals(new Rating(movieTitle1, value).getSource(), expected.getSource());
        Assert.assertEquals(new Rating(movieTitle1, value).getRating(), expected.getRating());
    }

    @Test
    public void testCorrectGetUserMovieRatings() {

        RatingList ratingList = ratingsResource.getUserRatings(movieTitle1);

        Assert.assertNotNull(ratingList);
        Assert.assertNotNull(ratingList.getRatings());
    }
}
