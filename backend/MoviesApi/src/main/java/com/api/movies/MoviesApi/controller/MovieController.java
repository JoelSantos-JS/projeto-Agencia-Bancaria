package com.api.movies.MoviesApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.movies.MoviesApi.entities.Movie;
import com.api.movies.MoviesApi.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {


    
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getallMovies() {
        
        return new ResponseEntity<List<Movie>>(movieService.findallMoviess(), HttpStatus.OK);
    }



}
