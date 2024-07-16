package com.example.weathertrackerapp;

import android.content.Context;

public class WeatherService {

    private Context context;

    public WeatherService(Context context) {
        this.context = context;
    }

    public interface WeatherCallback {
        void onSuccess(WeatherData weatherData);
        void onFailure(Exception e);
    }

    public void getCurrentWeather(WeatherCallback callback) {
        // Make API call to fetch current weather data
        // On success, call callback.onSuccess()
        // On failure, call callback.onFailure()
    }
}
