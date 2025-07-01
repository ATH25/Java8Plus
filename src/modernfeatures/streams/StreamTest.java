package modernfeatures.streams;

import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        names.stream()
             .filter(name -> name.length() > 3)
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}
