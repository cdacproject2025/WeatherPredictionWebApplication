
//package com.app.demo.controller;
//
//import com.app.demo.service.WeatherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/weather")
//@CrossOrigin(origins = "*") // Allow frontend to call API (important for React)
//public class WeatherController {
//
//    @Autowired
//    private WeatherService weatherService;
//
//    @GetMapping("/{city}")
//    public List<Map<String, Object>> getForecast(@PathVariable String city) {
//        return weatherService.getWeatherForecast(city);
//    }
//}
//



package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")


//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "http://localhost:5173")


public class WeatherController {

    @Value("${openweathermap.api.key}")
    private String apiKey;
    
    @GetMapping("/{city}")
    public ResponseEntity<String> getWeather(@PathVariable("city") String city) {
        city = city.replace(",", "%2C"); // Encode the comma

        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + apiKey + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return ResponseEntity.ok(response);
    }

    
    
////----Comment----
////    @GetMapping("/{city}")
////    public ResponseEntity<String> getWeather(@PathVariable String city) {
////        String url = "https://api.openweathermap.org/data/2.5/weather?q="
////                     + city + "&appid=" + apiKey + "&units=metric";
////
////        RestTemplate restTemplate = new RestTemplate();
////        String response = restTemplate.getForObject(url, String.class);
////
////        return ResponseEntity.ok(response);
////    }
////-------Comment-------    
//    
//    
//    
//    
//    
//    
//    
}
