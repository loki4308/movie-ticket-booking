package com.example.mtb.mapper;

import com.example.mtb.dto.MovieResponse;
import com.example.mtb.dto.SeatResponse;
import com.example.mtb.entity.Movie;
import com.example.mtb.entity.Seat;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    public MovieResponse movieResponseMapper(Movie movie, double avgRatings) {
        if (movie == null)
            return null;

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedRatings = df.format(avgRatings);

        return MovieResponse.builder()
                .movieId(movie.getMovieId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .ratings(formattedRatings)
                .runtime(movie.getRuntime())
                .certificate(movie.getCertificate())
                .genre(movie.getGenre())
                .castList(movie.getCastList())
                .build();
    }

    public Set<MovieResponse> movieResponseMapper(List<Movie> movies) {
        if (movies == null)
            return null;

        Set<MovieResponse> movieResponseList = new HashSet<>();
        for (Movie movie : movies){
            movieResponseList.add(MovieResponse.builder()
                    .movieId(movie.getMovieId())
                    .title(movie.getTitle())
                    .description(movie.getDescription())
                    .runtime(movie.getRuntime())
                    .certificate(movie.getCertificate())
                    .genre(movie.getGenre())
                    .castList(movie.getCastList())
                    .build());
        }
        return movieResponseList;
    }

}