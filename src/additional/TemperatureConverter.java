package additional;

/**
 * Utility class for converting temperatures between Celsius and Fahrenheit.
 * Can be used statically or instantiated with a specific temperature.
 */
public class TemperatureConverter {

    /**
     * Converts a temperature from Celsius to Fahrenheit.
     *
     * @param celsius the temperature in degrees Celsius
     * @return the converted temperature in degrees Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    // Instance field: Keeps track of a specific temperature in Celsius
    private double temperatureCelsius;

    /**
     * Constructs a TemperatureConverter object with a specific temperature.
     *
     * @param temperatureCelsius the initial temperature in degrees Celsius
     */
    public TemperatureConverter(double temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    /**
     * Converts the stored Celsius temperature to Fahrenheit.
     *
     * @return the temperature in degrees Fahrenheit
     */
    public double toFahrenheit() {
        return this.temperatureCelsius * 9 / 5 + 32;
    }

    /**
     * Updates the stored temperature in Celsius.
     *
     * @param newCelsius the new temperature in degrees Celsius
     */
    public void setTemperature(double newCelsius) {
        this.temperatureCelsius = newCelsius;
    }
}



