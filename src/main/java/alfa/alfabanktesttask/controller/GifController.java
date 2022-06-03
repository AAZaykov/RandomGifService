package alfa.alfabanktesttask.controller;

import alfa.alfabanktesttask.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class GifController{

    private GifService gifService;

    @Value("${curr}")
    private String currency;

    @Autowired
    public GifController(GifService gifService) {
        this.gifService = gifService;
    }

    @GetMapping("/result")
    public RedirectView getGif(){
        return new RedirectView(gifService.getGifUrl(currency));
    }
}