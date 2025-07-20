package modernfeatures.java14;

/**
 * Demonstrates Java 14+ switch expressions with concise syntax,
 * multiple case labels, returning values, and no accidental fall-through.
 */
public class SwitchExpressionsDemo {
    public static void main(String[] args) {
        String day = "SATURDAY";

        // Classic switch (before Java 14)
        int numLetters;
        switch (day) {
            case "MONDAY":
            case "FRIDAY":
            case "SUNDAY":
                numLetters = 6;
                break;
            case "TUESDAY":
                numLetters = 7;
                break;
            case "THURSDAY":
            case "SATURDAY":
                numLetters = 8;
                break;
            case "WEDNESDAY":
                numLetters = 9;
                break;
            default:
                numLetters = 0;
        }
        System.out.println("Classic switch: " + numLetters);

        // Switch expression (Java 14+)
        int numLettersNew = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 80;
            case "WEDNESDAY" -> 9;
            default -> 0;
        };
        System.out.println("Switch expression: " + numLettersNew);

        // Block in switch expression with yield
        String message = switch (day) {
            case "SATURDAY", "SUNDAY" -> {
                String weekend = "Enjoy the weekend!";
                yield weekend;
            }
            default -> "It's a work day.";
        };
        System.out.println("Switch expression with yield: " + message);
    }
}