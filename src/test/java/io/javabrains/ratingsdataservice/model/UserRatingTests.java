package io.javabrains.ratingsdataservice.model;

import io.javabrains.ratingsdataservice.PojoTestUtils;
import org.junit.Test;

public class UserRatingTests {

    @Test
    public void validateUserRatingGettersSettersTest() {
        PojoTestUtils.ValidateAccessors(UserRating.class);
    }
}
