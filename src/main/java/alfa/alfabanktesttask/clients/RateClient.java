package alfa.alfabanktesttask.clients;

import alfa.alfabanktesttask.dto.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${openexchangerates.url}", name = "Rate")
public interface RateClient {

    @GetMapping("/latest.json")
    Rate getLatestRates(@RequestParam("app_id") String appId);

    @GetMapping("/historical/{date}.json")
    Rate getHistoryRates(@PathVariable("date") String date,
                                @RequestParam("app_id") String appId);
}