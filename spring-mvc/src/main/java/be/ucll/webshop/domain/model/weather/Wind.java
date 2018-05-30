package be.ucll.webshop.domain.model.weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "speed",
    "deg"
})
public class Wind {

    @JsonProperty("speed")
    private double speed;
    @JsonProperty("deg")
    private int deg;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Wind() {
    }

    /**
     * 
     * @param speed
     * @param deg
     */
    public Wind(double speed, int deg) {
        super();
        this.speed = speed;
        this.deg = deg;
    }

    @JsonProperty("speed")
    public double getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Wind withSpeed(double speed) {
        this.speed = speed;
        return this;
    }

    @JsonProperty("deg")
    public int getDeg() {
        return deg;
    }

    @JsonProperty("deg")
    public void setDeg(int deg) {
        this.deg = deg;
    }

    public Wind withDeg(int deg) {
        this.deg = deg;
        return this;
    }

}
