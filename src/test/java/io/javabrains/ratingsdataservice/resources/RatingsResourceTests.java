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

    private String GET_MOVIE_RATING_PATH = "/ratingsdata/movies/";
    private String GET_USER_MOVIE_RATING_PATH = "/ratingsdata/user/";
    private Rating rating1, rating2;
    private RatingList ratingList1;
    private String movieTitle1;

    @Mock
    RatingsResource ratingsResourceMock;

    @BeforeEach
    public void init() {
        rating1 = new Rating("IMDB", "10/10");
        rating2 = new Rating("New York Times", "8.5");
        movieTitle1 = "Titanic";

        ratingList1 = new RatingList();
        ratingList1.setMovieTitle(movieTitle1);
        ratingList1.setRatings(Arrays.asList(rating1, rating2));

        ratingsResourceMock = Mockito.mock(RatingsResource.class);
    }

    @Test
    @DisplayName("Correct getMovieRating(String movieId)")
    public void testCorrectGetMovieRating() {
        String source = "foo";
        String rating = "4";

        Rating expected = new Rating(source, rating);

        when(ratingsResourceMock.getMovieRating(eq(source)))
                .thenReturn(new Rating(source, rating));

        Assert.assertEquals(expected.getRating(), ratingsResourceMock.getMovieRating(source).getRating());
        Assert.assertEquals(expected.getSource(), ratingsResourceMock.getMovieRating(source).getSource());
    }

    @Test
    @DisplayName("Correct getUserMovieRatings(String movieTitle)")
    public void testCorrectGetUserMovieRatings() {
        when(ratingsResourceMock.getUserRatings(eq(movieTitle1)))
                .thenReturn(ratingList1);

        Assert.assertEquals(movieTitle1, ratingsResourceMock.getUserRatings(movieTitle1).getMovieTitle());
        Assert.assertEquals(ratingList1.getRatings().size(), ratingsResourceMock.getUserRatings(movieTitle1).getRatings().size());

        compare(ratingList1.getRatings(), ratingsResourceMock.getUserRatings(movieTitle1).getRatings());
    }

    private void compare(List<Rating> expected, List<Rating> result) {
        for (int x =0; x < (expected.size()); x++){
            Assert.assertEquals(expected.get(x).getSource(), result.get(x).getSource());
            Assert.assertEquals(expected.get(x).getRating(), result.get(x).getRating());
        }
    }
}
