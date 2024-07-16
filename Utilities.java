package com.example.weathertrackerapp;

public class Utilities {

    public static String formatTemperature(double temperature) {
        return String.format("%.1f°C", temperature);
    }

    public static String formatCondition(String condition) {
        return condition;
    }
}
