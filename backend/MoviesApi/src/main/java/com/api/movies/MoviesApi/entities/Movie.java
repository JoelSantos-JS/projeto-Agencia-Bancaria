package com.api.movies.MoviesApi.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;
    private String imbdId;

    private String title;

    private String realeaseDate;

    private String trailerLink;

    private String  posterLinks;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviews;

    public Movie(String imbdId, String title, String realeaseDate, String trailerLink, String posterLinks,
            List<String> genres, List<String> backdrops) {
        this.imbdId = imbdId;
        this.title = title;
        this.realeaseDate = realeaseDate;
        this.trailerLink = trailerLink;
        this.posterLinks = posterLinks;
        this.genres = genres;
        this.backdrops = backdrops;
    }




    

    

    
    

    
}
