package com.RandomGifService;

import com.RandomGifService.controller.GifController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RandomGifServiceApplicationTests {

    @Autowired
    private GifController gifController;
    @Test
    void contextLoads() {
        assertThat(gifController).isNotNull();
    }

}
