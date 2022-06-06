package com.RandomGifService.service;

import com.RandomGifService.clients.GifClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GifService {

    private RateService rateService;

    private GifClient gifClient;

    @Value("${giphy.api_key}")
    private String apiKey;

    @Value("${currency}")
    private String curr;

    @Autowired
    public GifService(RateService rateService, GifClient gifClient) {
        this.rateService = rateService;
        this.gifClient = gifClient;
    }

    public String getGifUrl() {
        if (rateService.getLatestRates().getRates().get(curr) > rateService.getHistoryRates().getRates().get(curr)){
            return getURL(gifClient.getGifJson(apiKey, "rich"));
        }else return getURL(gifClient.getGifJson(apiKey, "broke"));
    }

    @SneakyThrows
    String getURL(String gifJson){
        return new ObjectMapper().readTree(gifJson).path("data").path("images").path("original").path("url").asText();
    }
}