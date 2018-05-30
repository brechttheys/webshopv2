
package be.ucll.webshop.domain.model.weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coord",
    "weather",
    "base",
    "main",
    "visibility",
    "wind",
    "clouds",
    "dt",
    "sys",
    "id",
    "name",
    "cod"
})
public class WeatherData {
    @JsonProperty("weather")
    private List<Weather> weather = null;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("clouds")
    private Clouds clouds;


    /**
     * No args constructor for use in serialization
     * 
     */
    public WeatherData() {
    }

    /**
     *
     * @param clouds
     * @param wind
     * @param weather
     * @param main
     */
    public WeatherData(List<Weather> weather, Main main, Wind wind, Clouds clouds) {
        super();
        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
    }

    @JsonProperty("weather")
    public List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public WeatherData withWeather(List<Weather> weather) {
        this.weather = weather;
        return this;
    }


    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    public WeatherData withMain(Main main) {
        this.main = main;
        return this;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public WeatherData withWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    @JsonProperty("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public WeatherData withClouds(Clouds clouds) {
        this.clouds = clouds;
        return this;
    }

}
