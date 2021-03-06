package gui;

import api.*;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LocationFactory locationFactory = NominatimLocationFactory.getInstance();

        try {
            Location location = locationFactory.getLocation("95843");

            System.out.println("zip code = " + location.getZipcode());
            System.out.println("location = " + location.getCityState());
            System.out.println("lat = " + location.getLatitude());
            System.out.println("lon = " + location.getLongitude());
            System.out.println();

            location = locationFactory.getLocation("95111");

            System.out.println("zip code = " + location.getZipcode());
            System.out.println("location = " + location.getCityState());
            System.out.println("lat = " + location.getLatitude());
            System.out.println("lon = " + location.getLongitude());
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Weather weather = new GovermentWeather();

        try {
            weather.refreshData("95843");
            System.out.println("zip code = 95843");
            List<WeatherRecord> weatherData = weather.getWeatherData();

            for (WeatherRecord entry : weatherData) {

                System.out.println("Period = " + entry.getPeriod());
                System.out.println(entry.getTempLabel() + " = " + entry.getTemp());
                System.out.println("weather = " + entry.getWeather());
                System.out.println("text = " + entry.getText());
                System.out.println("Image Link = " + entry.getIconLink());
                System.out.println();
            }


            weather.refreshData("95111");
            System.out.println("zip code = 95111");
            weatherData = weather.getWeatherData();

            for (WeatherRecord entry : weatherData) {

                System.out.println("Period = " + entry.getPeriod());
                System.out.println(entry.getTempLabel() + " = " + entry.getTemp());
                System.out.println("weather = " + entry.getWeather());
                System.out.println("text = " + entry.getText());
                System.out.println("Image Link = " + entry.getIconLink());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
