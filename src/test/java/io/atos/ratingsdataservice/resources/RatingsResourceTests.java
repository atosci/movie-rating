package io.atos.ratingsdataservice.resources;

import io.atos.ratingsdataservice.model.Rating;
import io.atos.ratingsdataservice.model.RatingList;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.eq;

public class RatingsResourceTests {

    private static final Rating rating1 = new Rating("IMDB", "10/10");
    private static final Rating rating2 = new Rating("New York Times", "8.5");
    private static final String movieTitle1 = "Titanic";
    private static RatingList ratingList1 = new RatingList();
    private RatingsResource ratingsResource;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @BeforeEach
    public void init() {
        ratingList1.setMovieTitle(movieTitle1);
        ratingList1.setRatings(Arrays.asList(rating1, rating2));

        ratingsResource = new RatingsResource();
    }

    @Test
    public void testCorrectGetMovieRating() {
        String value = "5";

        RatingsResource ratingsResource = new RatingsResource();
        Rating expected = ratingsResource.getMovieRating(movieTitle1);
        Assert.assertEquals(new Rating(movieTitle1, value).getSource(), expected.getSource());
        Assert.assertEquals(new Rating(movieTitle1, value).getValue(), expected.getValue());
    }

    @Test
    public void testCorrectGetUserMovieRatings() {

       // String expected = "\Ratings\":["{"Source":"Internet Movie Database","Value":"7.8/10"},{"Source":"Rotten Tomatoes","Value":"89%"},{"Source":"Metacritic","Value":"75/100"}]";
        RatingList expected = new RatingList();
        expected.setMovieTitle(movieTitle1);
        expected.setRatings(new ArrayList<Rating>() {{
            add(new Rating("Internet Movie Database", "7.8/10"));
            add(new Rating("Rotten Tomatoes", "89%"));
            add(new Rating("Metacritic", "75/100"));
        }});

        RatingList result = ratingsResource.getUserRatings(movieTitle1);

        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getMovieTitle(), result.getMovieTitle());
        compare(expected.getRatings(), result.getRatings());
    }

    private void compare(List<Rating> expected, List<Rating> result) {
        for (int x =0; x < (expected.size()); x++){
            Assert.assertEquals(expected.get(x).getSource(), result.get(x).getSource());
            Assert.assertEquals(expected.get(x).getValue(), result.get(x).getValue());
        }
    }

    @Test
    public void throwIOExceptionGetUserMovieRatings() {
        RatingList ratingList = ratingsResource.getUserRatings(null);

        Assert.assertNull(ratingList.getRatings());
        Assert.assertNull(ratingList.getMovieTitle());
    }
}
