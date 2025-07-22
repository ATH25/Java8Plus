package modernfeatures.java21;


/**
 * Demonstrates both the classic instanceof/cast approach and the modern pattern matching for switch (Java 21+)
 * using a classic class hierarchy.
 */
public class PatternMatchingSwitchClassicDemo {

    /**
     * Abstract base class representing an animal.
     */
    static abstract class Animal {
        public abstract String name();
    }

    /**
     * Represents a Cat, subclass of Animal.
     */
    static class Cat extends Animal {
        private final String name;
        Cat(String name) { this.name = name; }
        @Override public String name() { return name; }
    }

    /**
     * Represents a Dog, subclass of Animal.
     */
    static class Dog extends Animal {
        private final String name;
        Dog(String name) { this.name = name; }
        @Override public String name() { return name; }
    }

    /**
     * Demonstrates two approaches to type checking and handling:
     * 1. Classic approach using instanceof and casting.
     * 2. Modern approach using pattern matching for switch (Java 21+).
     */
    public static void main(String[] args) {
        // Test data: an array of Animal instances including Cats and Dogs
        Animal[] animals = {new Cat("Whiskers"), new Dog("Fido"), new Cat("Mittens")};

        // Classic approach (pre-Java 16/21): using instanceof and explicit cast
        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                Cat c = (Cat) animal;
                System.out.println("[Classic] Cat: " + c.name());
            } else if (animal instanceof Dog) {
                Dog d = (Dog) animal;
                System.out.println("[Classic] Dog: " + d.name());
            } else {
                System.out.println("[Classic] Unknown animal: " + animal);
            }
        }

        // Modern pattern matching for switch (Java 21+): concise and type-safe matching
        for (Animal animal : animals) {
            String desc = switch (animal) {
                // Matches if animal is a Cat, binds to variable c
                case Cat c -> "Cat: " + c.name();
                // Matches if animal is a Dog, binds to variable d
                case Dog d -> "Dog: " + d.name();
                // Matches any other type of Animal not explicitly handled above
                default   -> "Unknown animal: " + animal;
            };
            System.out.println("[Pattern Matching] " + desc);
        }
    }
}
