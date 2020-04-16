package io.javabrains.ratingsdataservice.resources;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.UserRating;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class RatingsResourceTests {

    private String GET_MOVIE_RATING_PATH = "/ratingsdata/movies/";
    private String GET_USER_MOVIE_RATING_PATH = "/ratingsdata/user/";

    @Mock
    RatingsResource ratingsResourceMock;

    @BeforeEach
    public void init() {
        ratingsResourceMock = Mockito.mock(RatingsResource.class);
    }

    @Test
    @DisplayName("Correct getMovieRating(String movieId)")
    public void testCorrectGetMovieRating() {
        String movieId = "foo";
        int rating = 4;

        Rating expected = new Rating(movieId, rating);

        when(ratingsResourceMock.getMovieRating(eq(movieId)))
                .thenReturn(new Rating(movieId, rating));

        Assert.assertEquals(expected.getRating(), ratingsResourceMock.getMovieRating(movieId).getRating());
        Assert.assertEquals(expected.getMovieId(), ratingsResourceMock.getMovieRating(movieId).getMovieId());
    }

    @Test
    @DisplayName("Correct getUserMovieRatings(String userId)")
    public void testCorrectGetUserMovieRatings() {
        String userId = "4";

        UserRating expected = new UserRating();
        expected.initData(userId);

        UserRating result = new UserRating();
        result.initData(userId);

        when(ratingsResourceMock.getUserRatings(eq(userId)))
                .thenReturn(result);
        Assert.assertEquals(expected.getUserId(), ratingsResourceMock.getUserRatings(userId).getUserId());
        Assert.assertEquals(expected.getRatings().size(), ratingsResourceMock.getUserRatings(userId).getRatings().size());

        compare(expected.getRatings(), ratingsResourceMock.getUserRatings(userId).getRatings());
    }

    private void compare(List<Rating> expected, List<Rating> result) {
        for (int x =0; x < (expected.size()); x++){
            Assert.assertEquals(expected.get(x).getMovieId(), result.get(x).getMovieId());
            Assert.assertEquals(expected.get(x).getRating(), result.get(x).getRating());
        }
    }

}
