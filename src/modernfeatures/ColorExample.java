public class ColorExample {
    public static void main(String[] args) {
        // ANSI escape code for red text
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String RESET = "\u001B[0m";

        System.out.printf(RED + "This is red text%n" + RESET);
        System.out.printf(GREEN + "This is green text%n" + RESET);
    }
}