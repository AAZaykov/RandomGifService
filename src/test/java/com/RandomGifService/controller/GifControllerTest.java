package com.RandomGifService.controller;

import com.RandomGifService.service.GifService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class GifControllerTest {

    @Mock
    private GifService gifService;

    @InjectMocks
    GifController gifController;

    @Test
    void testGetGif(){
        gifController.getGif();
        verify(gifService).getGifUrl();
    }
}