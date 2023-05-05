package com.api.movies.MoviesApi.respository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.movies.MoviesApi.entities.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie,ObjectId> {
    
}
