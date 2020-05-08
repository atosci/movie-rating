package io.atos.ratingsdataservice.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.atos.ratingsdataservice.model.Rating;
import io.atos.ratingsdataservice.model.RatingList;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    private static final Logger LOGGER = Logger.getLogger( RatingsResource.class.getName() );

    private static final String URI = "http://www.omdbapi.com/?t=%s&apikey=cc323c12";

    @GetMapping(path = "/movies/{movieTitle}")
    public Rating getMovieRating(@PathVariable("movieTitle") String movieTitle) {
        return new Rating(movieTitle, "5");
    }

    @GetMapping(path = "/user/{movieTitle}")
    public RatingList getUserRatings(@PathVariable("movieTitle") String movieTitle) {
        RatingList ratingList = new RatingList();
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String result;

        try {
            if (movieTitle == null) {
                throw new NullPointerException();
            }

            result = restTemplate.getForObject(String.format(URI, movieTitle), String.class);
            JsonNode root = objectMapper.readTree(result);

            Rating[] list = objectMapper.readValue(root.get("Ratings").toString(), Rating[].class);

            ratingList.setRatings(Arrays.asList(list));
            ratingList.setMovieTitle(movieTitle);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString());
        }
        return ratingList;
    }

}
