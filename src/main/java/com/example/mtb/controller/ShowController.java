package com.example.mtb.controller;

import com.example.mtb.dto.MovieShowsRequest;
import com.example.mtb.dto.ShowResponse;
import com.example.mtb.dto.TheaterShowProjection;
import com.example.mtb.service.ShowService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.StructureResponseBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Validated
public class ShowController {

    private final ShowService showService;

    // Testing completed.
    @PostMapping("theaters/{theaterId}/screens/{screenId}/shows")
    public ResponseEntity<ResponseStructure<ShowResponse>> addShow(@PathVariable String theaterId, @PathVariable String screenId, String movieId , @NotNull Long startTime, @NotNull String zoneId ){
        ShowResponse showResponse = showService.addShow(theaterId, screenId, movieId, startTime, zoneId);
        return new StructureResponseBuilder().success(HttpStatus.OK, "Show sucessfully created", showResponse);
    }
   // Testing not completed........
   @GetMapping("movies/{movieId}/shows")
    public ResponseEntity<ResponseStructure<Page<TheaterShowProjection>>> fetchShows(
            @PathVariable String movieId,
            @RequestBody MovieShowsRequest showsRequest,
            @RequestHeader(value = "X-City", required = false)  String city // Header for city
    ) {
        Page<TheaterShowProjection> shows  = showService.fetchShows(movieId, showsRequest, city);
        return new StructureResponseBuilder().success(HttpStatus.OK, "Fetched Succesfully", shows);
    }



}
