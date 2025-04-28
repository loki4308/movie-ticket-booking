package com.example.mtb.controller;

import com.example.mtb.dto.ScreenRequest;
import com.example.mtb.dto.ScreenResponse;
import com.example.mtb.dto.TheaterRequest;
import com.example.mtb.dto.TheaterResponse;
import com.example.mtb.service.ScreenService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.StructureResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/screens")
@AllArgsConstructor
public class ScreenController {

    private ScreenService screenService;

    @PostMapping("/theaters/{theaterId}/screens")
    public ResponseEntity<ResponseStructure<ScreenResponse>> createScreen(
            @RequestBody ScreenRequest request,
            @PathVariable String theaterId
    ){
        ScreenResponse screenResponse = screenService.createScreen(request, theaterId);
        return new StructureResponseBuilder().success(HttpStatus.CREATED, "Theater Created", screenResponse);
    }

    @GetMapping("/screens/{screenId}")
    public ResponseEntity<ResponseStructure<ScreenResponse>> findByScreenId(@PathVariable String screenId){
        ScreenResponse screenResponse = screenService.findByScreenId(screenId);
        return new StructureResponseBuilder().success(HttpStatus.FOUND, "Screen found successfully", screenResponse);
    }

    @PutMapping("/screens/{screenId}")
    public ResponseEntity<ResponseStructure<ScreenResponse>> updateScreenById(@RequestBody ScreenRequest request, @PathVariable String screenId){
        ScreenResponse screenResponse = screenService.updateScreenById(request, screenId);
        return new StructureResponseBuilder().success(HttpStatus.OK, "Screen Updated Successfully", screenResponse);
    }


}
