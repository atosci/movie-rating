package io.javabrains.ratingsdataservice.model;

import io.javabrains.ratingsdataservice.PojoTestUtils;
import org.junit.Test;

public class RatingListTests {

    @Test
    public void validateUserRatingGettersSettersTest() {
        PojoTestUtils.ValidateAccessors(RatingList.class);
    }
}
