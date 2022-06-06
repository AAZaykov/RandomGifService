package alfa.alfabanktesttask.service;

import alfa.alfabanktesttask.clients.RateClient;
import alfa.alfabanktesttask.dto.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class RateService {

    private final RateClient rateClient;

    @Autowired
    public RateService(RateClient rateClient) {
        this.rateClient = rateClient;
    }

    @Value("${openexchangerates.app_id}")
    private String appId;

    public Rate getLatestRates() {
        return rateClient.getLatestRates(appId);
    }

    public Rate getHistoryRates(){
        return rateClient.getHistoryRates(LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE), appId);
    }

}