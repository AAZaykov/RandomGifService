package com.RandomGifService.controller;

import com.RandomGifService.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class GifController{

    private GifService gifService;

    @Value("${currency}")
    private String currency;

    @Autowired
    public GifController(GifService gifService) {
        this.gifService = gifService;
    }

    @GetMapping("/result")
    public RedirectView getGif(){
        return new RedirectView(gifService.getGifUrl());
    }
}
