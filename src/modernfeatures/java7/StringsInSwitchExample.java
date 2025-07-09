package modernfeatures.java7;

import java.util.Scanner;

/**
 * Demonstrates Java 7's feature: using Strings in switch statements.
 * Prompts the user to enter a command, then responds based on input.
 */
public class StringsInSwitchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a command (start/stop/pause): ");
        String command = scanner.nextLine();

        switch (command) {
            case "start":
                System.out.println("Starting the process...");
                break;
            case "stop":
                System.out.println("Stopping the process...");
                break;
            case "pause":
                System.out.println("Pausing the process...");
                break;
            default:
                System.out.println("Unknown command!");
        }

        scanner.close();
    }
}