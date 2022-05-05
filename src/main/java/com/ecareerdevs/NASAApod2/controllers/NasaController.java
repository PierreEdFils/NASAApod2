package com.ecareerdevs.NASAApod2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


//First step is to add the RestController and RequestMapping annotations to the NasaController class
@RestController
@RequestMapping("/nasa")

public class NasaController {

//    Second step is to create a nasaApodEndpoint field within your new class

    private String myNasaKey = "DEMO_KEY";

//  Third step is to add a route handler to your code.

    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;

    @GetMapping("/apod")
    public Object apodHandler (RestTemplate restTemplate) {
        return restTemplate.getForObject(nasaApodEndpoint, Object.class);
    }

    @GetMapping ("/params")
    public  String test (@RequestParam String name){
        return "Hello "+ name;
    }
}
