package cau_hoi_java.presentation;

public class Cat extends Animal implements Jumpable{

    public Cat(String name){
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Meow!");
    }

    @Override
    public String abc() {
        return null;
    }

    @Override
    public void jump() {
        System.out.println("The cat jumps.");
    }

}
