package io.javabrains.ratingsdataservice.model;

import io.javabrains.ratingsdataservice.PojoTestUtils;
import org.junit.Test;

public class RatingsTests {

    @Test
    public void validateRatingGettersSettersTest() {
        PojoTestUtils.ValidateAccessors(Rating.class);
    }

}
