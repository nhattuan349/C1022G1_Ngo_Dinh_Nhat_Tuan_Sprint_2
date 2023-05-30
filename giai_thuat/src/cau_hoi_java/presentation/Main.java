package cau_hoi_java.presentation;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom");
        cat.sound();  // Output: Meow!
        cat.jump();   // Output: The cat jumps.
        System.out.println(cat.getName());  // Output: Tom
    }
}
