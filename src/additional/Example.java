package additional;

/**
 * Example class demonstrating usage of TemperatureConverter.
 */
class Example {

    /**
     * Main method demonstrating static and instance method usage.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Static method: no object needed, just pass value
        double f1 = TemperatureConverter.celsiusToFahrenheit(100);
        System.out.println("100°C in Fahrenheit: " + f1);

        // Instance method: tied to object state
        TemperatureConverter tc = new TemperatureConverter(37.0);
        double f2 = tc.toFahrenheit();
        System.out.println("37°C in Fahrenheit: " + f2);

        // Update temperature and convert again
        tc.setTemperature(0);
        System.out.println("0°C in Fahrenheit (after update): " + tc.toFahrenheit());
    }
}
