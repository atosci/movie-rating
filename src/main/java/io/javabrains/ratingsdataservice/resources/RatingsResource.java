package io.javabrains.ratingsdataservice.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.RatingList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    final String uri = "http://www.omdbapi.com/?t=%s&apikey=cc323c12";

    @RequestMapping("/movies/{movieTitle}")
    public Rating getMovieRating(@PathVariable("movieTitle") String movieTitle) {
        return new Rating(movieTitle, "5");
    }

    @RequestMapping("/user/{movieTitle}")
    public RatingList getUserRatings(@PathVariable("movieTitle") String movieTitle) {
        RatingList ratingList = new RatingList();
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(String.format(uri, movieTitle), String.class);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode root = objectMapper.readTree(result);
            Rating[] list = objectMapper.readValue(root.get("Ratings").toString(), Rating[].class);
            ratingList.setRatings(Arrays.asList(list));
            ratingList.setMovieTitle(movieTitle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ratingList;
    }

}
