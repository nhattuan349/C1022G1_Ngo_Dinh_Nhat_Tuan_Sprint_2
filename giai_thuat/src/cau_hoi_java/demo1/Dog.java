package cau_hoi_java.demo1;

public class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void move() {
        System.out.println("Dog is running.");
    }
}
