package io.javabrains.ratingsdataservice.resources;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.javabrains.ratingsdataservice.model.Rating;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(classes = SpringBootApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RatingsResoureceIntegrationTests {

    @LocalServerPort
    private int port;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8083);

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCorrectGetMovieRating() {

    }

    @Test
    public void testCorrectGetUserMovieRatings() {

    }

}
