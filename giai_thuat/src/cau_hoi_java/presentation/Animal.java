package cau_hoi_java.presentation;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void sound();

    public abstract String abc();

    public String getName() {
        return name;
    }
}
