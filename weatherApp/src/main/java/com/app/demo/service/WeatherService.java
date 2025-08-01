//package com.app.demo.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.http.ResponseEntity;
//import java.util.*;
//
//@Service
//public class WeatherService {
//
//    private final String API_KEY = "30ae51951dcda8ddaf2fc2e884919436";
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    public List<Map<String, Object>> getWeatherForecast(String city) {
//        // 1. Call Geocoding API to get coordinates
//        String geoUrl = "http://api.openweathermap.org/geo/1.0/direct?q=" + city + "&limit=1&appid=" + API_KEY;
//        ResponseEntity<List> geoResponse = restTemplate.getForEntity(geoUrl, List.class);
//        List<Map<String, Object>> geoData = geoResponse.getBody();
//
//        if (geoData == null || geoData.isEmpty()) {
//            return Collections.emptyList();
//        }
//
//        double lat = (double) geoData.get(0).get("lat");
//        double lon = (double) geoData.get(0).get("lon");
//
//        // 2. Call One Call API
//        String weatherUrl = "https://api.openweathermap.org/data/2.5/forecast?lat=" + lat +
//                "&lon=" + lon + "&exclude=minutely,hourly,alerts&units=metric&appid=" + API_KEY;
//
//        ResponseEntity<Map> weatherResponse = restTemplate.getForEntity(weatherUrl, Map.class);
//        Map<String, Object> weatherData = weatherResponse.getBody();
//
//        if (weatherData != null && weatherData.containsKey("daily")) {
//            return (List<Map<String, Object>>) weatherData.get("daily");
//        }
//
//        return Collections.emptyList();
//    }
//}
