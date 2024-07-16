package com.example.weathertrackerapp;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherFragment extends Fragment {

    private RecyclerView recyclerView;
    private WeatherAdapter weatherAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Initialize adapter and set it to the RecyclerView
        weatherAdapter = new WeatherAdapter();
        recyclerView.setAdapter(weatherAdapter);

        // Fetch and display weather data
        fetchWeatherData();

        return view;
    }

    private void fetchWeatherData() {
        // Call WeatherService to fetch data and update UI
        WeatherService weatherService = new WeatherService(getActivity());
        weatherService.getCurrentWeather(new WeatherService.WeatherCallback() {
            @Override
            public void onSuccess(WeatherData weatherData) {
                updateUI(weatherData);
            }

            @Override
            public void onFailure(Exception e) {
                // Handle error
            }
        });
    }

    private void updateUI(WeatherData weatherData) {
        // Update the UI with weather data
        weatherAdapter.setWeatherData(weatherData);
    }
}
