package modernfeatures.java13;

/**
 * Demonstrates Java text blocks (multi-line string literals, introduced in Java 13+ and finalized in Java 15+).
 */
public class TextBlocksDemo {
    public static void main(String[] args) {
        // Before Java 13: messy concatenation or lots of \n
        String jsonOld = "{\n" +
                "  \"name\": \"Aju\",\n" +
                "  \"role\": \"Java Developer\"\n" +
                "}";

        System.out.println("Classic multi-line string:");
        System.out.println(jsonOld);

        // Java 13+ Text Block: triple double-quote
        String json = """
            {
              "name": "Aju",
              "role": "Java Developer"
            }
            """;

        System.out.println("\nText block:");
        System.out.println(json);

        // SQL example
        String sql = """
            SELECT id, name, salary
            FROM employees
            WHERE salary > 50000
            ORDER BY salary DESC
            """;

        System.out.println("\nText block (SQL):");
        System.out.println(sql);

        // Text blocks keep formatting, embedded quotes, and whitespace
        String html = """
            <html>
              <body>
                <h1>Welcome, "Aju"!</h1>
                <p>This is a text block demo.</p>
              </body>
            </html>
            """;

        System.out.println("\nText block (HTML):");
        System.out.println(html);

        // Compare: escaping quotes in classic vs. text block
        String classic = "He said, \"Hello, world!\"";
        String block = """
            He said, "Hello, world!"
            """;
        System.out.println("\nClassic with escapes: " + classic);
        System.out.println("Text block with no escapes: " + block);
    }
}