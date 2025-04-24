package com.example.mtb.controller;

import com.example.mtb.dto.TheaterRequest;
import com.example.mtb.dto.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.service.TheaterService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.StructureResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
@AllArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping
    public ResponseEntity<ResponseStructure<TheaterResponse>> createTheater(
            @RequestBody TheaterRequest request,
            @RequestParam String email
            ){
        TheaterResponse theaterResponse = theaterService.createTheater(request, email);
        return new StructureResponseBuilder().success(HttpStatus.CREATED, "Theater Created", theaterResponse);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<TheaterResponse>> findByTheaterId(@RequestParam String id){
        return new StructureResponseBuilder().success(HttpStatus.FOUND, "Theater found successfully", theaterService.findTheaterById(id));
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<TheaterResponse>> updateTheaterById(@RequestBody TheaterRequest request, @RequestParam String id){
        return new StructureResponseBuilder().success(HttpStatus.OK, "Theater updated successfully", theaterService.updateTheaterById(request, id));
    }
}
