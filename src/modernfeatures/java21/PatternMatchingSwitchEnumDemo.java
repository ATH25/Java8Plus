package modernfeatures.java21;

/**
 * Demonstrates Java 21+ pattern matching for switch with enums.
 * This example shows how to use modern switch expressions for concise and exhaustive handling of enum values.
 */
public class PatternMatchingSwitchEnumDemo {

    /**
     * Enum modeling the colors of a traffic light.
     */
    enum TrafficLight {
        RED, YELLOW, GREEN
    }

    /**
     * Iterates over all TrafficLight enum values and uses a modern switch expression
     * to provide concise and exhaustive handling of each case.
     */
    public static void main(String[] args) {
        // Test data covering all TrafficLight enum values
        TrafficLight[] signals = {TrafficLight.RED, TrafficLight.YELLOW, TrafficLight.GREEN};

        for (TrafficLight light : signals) {
            // Modern switch expression with arrow syntax and exhaustive cases for TrafficLight enum
            String action = switch (light) {
                case RED -> "Stop";
                case YELLOW -> "Caution";
                case GREEN -> "Go";
            };
            System.out.println(light + ": " + action);
        }
    }
}
