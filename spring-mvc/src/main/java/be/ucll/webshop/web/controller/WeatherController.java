package be.ucll.webshop.web.controller;

import be.ucll.webshop.domain.model.weather.WeatherData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/weather")
public class WeatherController {

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView getWeatherInLeuven() {
        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=Leuven&APPID=f9a4e8dd5d3f0210072876cd73d8e27b", WeatherData.class);
        return new ModelAndView("weather", "weatherData", weatherData);
    }
}
