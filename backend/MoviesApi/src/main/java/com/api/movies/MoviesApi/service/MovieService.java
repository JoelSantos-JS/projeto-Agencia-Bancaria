package com.api.movies.MoviesApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.movies.MoviesApi.entities.Movie;
import com.api.movies.MoviesApi.respository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findallMoviess() {
        return movieRepository.findAll();
    
    } 
    
}
