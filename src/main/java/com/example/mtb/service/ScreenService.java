package com.example.mtb.service;

import com.example.mtb.dto.ScreenRequest;
import com.example.mtb.dto.ScreenResponse;
import com.example.mtb.dto.TheaterRequest;

public interface ScreenService {

    public ScreenResponse createScreen(ScreenRequest request, String theaterId);

    public ScreenResponse findByScreenId(String screenId);

    public ScreenResponse updateScreenById(ScreenRequest request, String screenId);
}
