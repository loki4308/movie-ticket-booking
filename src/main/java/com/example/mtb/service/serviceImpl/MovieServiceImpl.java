package com.example.mtb.service.serviceImpl;

import com.example.mtb.dto.MovieResponse;
import com.example.mtb.entity.Movie;
import com.example.mtb.exception.ScreenNotExistException;
import com.example.mtb.repository.MovieRepository;
import com.example.mtb.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public MovieResponse getMovie(String movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new ScreenNotExistException("Screen not exist"));

        double avgRatings = 0;

        for (Feedback feedback : movie.getFeedbacks()) {
            avgRatings += feedback.getRating();
        }
        return null;
    }

    @Override
    public Set<MovieResponse> searchMovies(String search) {
        return Set.of();
    }
}
