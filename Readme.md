# Atosci movie database - microservice application

## Introduction
Atosci movie database is a microservice application. That means that it is build up by more than one application, so not like monolithical application.
Every microservice works individually but to make the application work as a whole you need every microservice working.

The Atosci movie database is an application that let the user search for movie information on a webpage. The application uses the api from OMDB to get the movie information.

## Microsevices

The application is build out of three microservices: Movie-info, Movie-rating and movie-catalog.
Movie-info and Movie-rating can work separatly and displays JSON data on a webpage. Movie-catalog is dependend on the other two and can not work separatly.

[image]: Microservices.png

![microservices][image]


#### Movie-info

Movie-info gets the general information of a movie and displays it in JSON format on the webpage.
The information that is displayed is: Title, Plot, Year, Gerne, Director, Actors and the Poster of the movie which is displayed as an image.

#### Movie-rating

Movie-rating gets the rating information from a movie and displays it in JSON format on the webpage.
The ratings it gets can differ and depends on which rating critic IMDB has used for a given movie.


#### Movie-catalog

Movie-catalog gets the information that movie-info and movie-rating provide and displays it on a webpage styled in HTML and bootstrap.
