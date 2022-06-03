package alfa.alfabanktesttask.service;

import alfa.alfabanktesttask.clients.GifClient;
import com.fasterxml.jackson.core.JsonProcessingException;
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

    @Value("${curr}")
    private String curr;

    @Autowired
    public GifService(RateService rateService, GifClient gifClient) {
        this.rateService = rateService;
        this.gifClient = gifClient;
    }

    public String getGifUrl(String currency) {
        if (rateService.getLatestRates().getRates().get(curr) > rateService.getHistoryRates().getRates().get(curr)){
            return getURL(gifClient.getGifJson(apiKey, "rich"));
        }else return getURL(gifClient.getGifJson(apiKey, "broke"));
    }

    @SneakyThrows
    private String getURL(String gifJson){
        return new ObjectMapper().readTree(gifJson).path("data").path("images").path("original").path("url").asText();
    }
}