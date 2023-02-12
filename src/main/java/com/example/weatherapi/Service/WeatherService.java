package com.example.weatherapi.Service;

import com.example.weatherapi.Entity.CityCoordinate;
import com.example.weatherapi.Entity.WeatherData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    public static final String ApiKey = "ea16c6e762bb69312db748deb886ba63";

    public ResponseEntity getWeather(String city, String interval) {

        /* İnterval değişkeniyle alınan tarih bilgisine göre aşşağıdaki call api linki sadece değişecekti fakat openweather api ı current weather
        dışındaki api kullanımlarına ücretlendirme koyduğu için o kısmı yazmadım fakat aşşağıdaki kodun aynısını sadece yukardeki interval değişkenine
        göre ayarlanmasıyla aynı sonuç elde edilecektir.
         */

        String url = "http://api.openweathermap.org/geo/1.0/direct?q="
                + city
                + "&limit=10&appid="
                + ApiKey;
        RestTemplate restTemplate = new RestTemplate();


        CityCoordinate[] cityCoordinate = restTemplate.getForObject(url, CityCoordinate[].class);
        //city coordinate objesinin json arrayi

        String weatherUrl = "https://api.openweathermap.org/data/2.5/weather?lat="
                + cityCoordinate[0].getLat()
                + "&lon="
                + cityCoordinate[0].getLon()
                + "&lang=tr"
                + "&units=metric"
                + "&appid=" + ApiKey;
        WeatherData weatherData = restTemplate.getForObject(weatherUrl, WeatherData.class);

        String newline = System.getProperty("line.separator");

        /* Aşağıdaki fonksiyon çıktı olarak api den gelen bütün veriyi döndürüyor istenildiği taktirde objenin
        to string methodu tekrardan override edilerek sadece istenilen çıktılar alınabilir */
        return ResponseEntity.ok(
                city + " Şehrinin hava durumuna ait bilgiler aşşağıdaki gibidir: " + newline + weatherData.toString() + "(C°)"
        );

    }
}
