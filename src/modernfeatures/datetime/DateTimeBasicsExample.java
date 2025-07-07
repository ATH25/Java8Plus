package modernfeatures.datetime;

import java.time.*;

/**
 * Demonstrates core features of the Java 8 Date and Time API (java.time package).
 * Covers LocalDate, LocalTime, LocalDateTime, Instant, Period, Duration, and DateTimeFormatter basics.
 */
public class DateTimeBasicsExample {
    public static void main(String[] args) {
        // --- LocalDate: Date without time (year, month, day) ---
        LocalDate today = LocalDate.now();
        System.out.println("Today's date: " + today);

        LocalDate specificDate = LocalDate.of(2022, Month.JUNE, 15);
        System.out.println("Specific date: " + specificDate);

        // --- LocalTime: Time without date (hour, minute, second, nano) ---
        LocalTime nowTime = LocalTime.now();
        System.out.println("Current time: " + nowTime);

        LocalTime specificTime = LocalTime.of(14, 30, 0); // 2:30 PM
        System.out.println("Specific time: " + specificTime);

        // --- LocalDateTime: Combines date and time (no timezone) ---
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + nowDateTime);

        LocalDateTime specificDateTime = LocalDateTime.of(today, specificTime);
        System.out.println("Specific date and time: " + specificDateTime);

        // --- Instant: A point on the timeline (UTC) ---
        Instant instant = Instant.now();
        System.out.println("Current instant (UTC): " + instant);

        // --- Period: Amount of time in terms of years, months, days (date-based) ---
        Period tenDays = Period.ofDays(10);
        LocalDate tenDaysLater = today.plus(tenDays);
        System.out.println("Date 10 days from now: " + tenDaysLater);

        Period periodBetween = Period.between(specificDate, today);
        System.out.println("Period between " + specificDate + " and today: " + periodBetween);

        // --- Duration: Amount of time in seconds, nanos (time-based) ---
        Duration twoHours = Duration.ofHours(2);
        LocalTime twoHoursLater = nowTime.plus(twoHours);
        System.out.println("Time 2 hours from now: " + twoHoursLater);

        // --- Formatting and parsing dates/times ---
        // For full formatting options, see DateTimeFormatter JavaDocs
        String formattedDate = today.format(java.time.format.DateTimeFormatter.ISO_DATE);
        System.out.println("Formatted date (ISO): " + formattedDate);

        LocalDate parsedDate = LocalDate.parse("2023-12-25");
        System.out.println("Parsed LocalDate: " + parsedDate);

        // --- Time zones (brief intro) ---
        ZonedDateTime zonedNow = ZonedDateTime.now();
        System.out.println("Current date and time with time zone: " + zonedNow);

        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("New York current date and time: " + newYorkTime);

        // --- Summary: Core API is immutable, thread-safe, and easy to use! ---
    }
}