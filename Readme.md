# Atosci movie database - microservice application

## Introduction
Atosci movie database is a microservice application. That means that it is build up by more than one application, so not like monolithic application.
Every microservice works individually but to make the application work as a whole you need every microservice working.

The Atosci movie database is an application that let the user search for movie information on a web page. The application uses the api from OMDB to get the movie information.

#### The purpose of this application

This application will be used for the Jenkins pipeline to demonstrate that the pipeline can build, test and deploy the three microservices successfully.


## Microservices

The application is build out of three microservices: Movie-info, Movie-rating and Movie-catalog.
Movie-info and Movie-rating can work separately and displays JSON data on a web page. Movie-catalog is dependent on the other two and cannot work separately.

[image]: Microservices.png

![microservices][image]


#### Movie-info

Movie-info gets the general information of a movie and displays it in JSON format on the web page.
The information that is displayed is: Title, Plot, Year, Gerne, Director, Actors and the hyperlink of the Poster of the movie which is displayed as an image.

#### Movie-rating

Movie-rating gets the rating information from a movie and displays it in JSON format on the webpage.
The ratings it gets can differ and depends on which rating critic IMDB has used for a given movie.


#### Movie-catalog

Movie-catalog gets the information that movie-info and movie-rating provide and displays it on a web page styled in HTML and bootstrap.
