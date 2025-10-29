package com.example.mtb.controller;

import com.example.mtb.dto.MovieResponse;
import com.example.mtb.service.MovieService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.StructureResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<ResponseStructure<MovieResponse>> getMovie(@PathVariable String movieId){
        MovieResponse movieResponse = movieService.getMovie(movieId);
        return new StructureResponseBuilder().success(HttpStatus.OK, "Movie has been successfully fetched", movieResponse);
    }

    // This i have done before doing rating feature.
    @GetMapping("/mov/{search}")
    public ResponseEntity<ResponseStructure<Set<MovieResponse>>> searchMovies(@PathVariable String search){
        Set<MovieResponse> movieResponses = movieService.searchMovies(search);
        return new StructureResponseBuilder().success(HttpStatus.OK, "Movies fetched Succesfully", movieResponses);
    }

}