package modernfeatures.java11;

/**
 * Demonstrates new String methods added in Java 11:
 * <ul>
 *   <li>{@code isBlank()}</li>
 *   <li>{@code lines()}</li>
 *   <li>{@code strip()}, {@code stripLeading()}, {@code stripTrailing()}</li>
 *   <li>{@code repeat(int)}</li>
 * </ul>
 */
public class StringMethodsDemo {
    public static void main(String[] args) {
        String s1 = "   ";
        String s2 = "Hello\nWorld\nJava 11";
        String s3 = "   Leading and trailing spaces   ";
        String s4 = "Aju ";

        // isBlank()
        System.out.println("isBlank:");
        System.out.println("s1.isBlank(): " + s1.isBlank()); // true

        // lines()
        System.out.println("\nlines:");
        s2.lines().forEach(System.out::println);

        // strip, stripLeading, stripTrailing
        System.out.println("\nstrip:");
        System.out.println("[" + s3.strip() + "]");
        System.out.println("stripLeading: [" + s3.stripLeading() + "]");
        System.out.println("stripTrailing: [" + s3.stripTrailing() + "]");

        // repeat
        System.out.println("\nrepeat:");
        System.out.println(s4.repeat(3)); // "Aju Aju Aju "
    }
}