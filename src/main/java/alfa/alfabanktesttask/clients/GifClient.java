package alfa.alfabanktesttask.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${giphy.url}", name = "gif")
public interface GifClient {

    @GetMapping
    String getGifJson(@RequestParam("api_key") String apiKey, @RequestParam("tag") String tag);

}