package cau_hoi_java.demo1;

public class AnimalManagement {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat(); // Kết quả: Dog is eating.
        dog.move(); // Kết quả: Dog is running.
        dog.sleep(); // Kết quả: Animal is sleeping.

        Animal cat = new Cat();
        cat.eat(); // Kết quả: Cat is eating.
        cat.move(); // Kết quả: Cat is jumping.
        cat.sleep(); // Kết quả: Animal is sleeping.
    }
}
