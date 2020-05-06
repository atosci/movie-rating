package io.atos.ratingsdataservice.model;

import io.atos.ratingsdataservice.PojoTestUtils;
import org.junit.Test;

public class RatingsTests {

    @Test
    public void validateRatingGettersSettersTest() {
        PojoTestUtils.ValidateAccessors(Rating.class);
    }

}
