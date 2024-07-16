package com.example.weathertrackerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private WeatherData weatherData;

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_item, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        // Bind weather data to the ViewHolder
        holder.bind(weatherData.getHourlyForecast().get(position));
    }

    @Override
    public int getItemCount() {
        return weatherData != null ? weatherData.getHourlyForecast().size() : 0;
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {

        private TextView temperatureTextView;
        private TextView conditionTextView;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            temperatureTextView = itemView.findViewById(R.id.temperature_text);
            conditionTextView = itemView.findViewById(R.id.condition_text);
        }

        public void bind(WeatherData.HourlyForecast forecast) {
            temperatureTextView.setText(forecast.getTemperature());
            conditionTextView.setText(forecast.getCondition());
        }
    }
}
