package vn.edu.rikkei.session10.ex02;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        String message = "[Cat " + getName() + "] says: Meow! Meow!";
        System.out.printf("| %-53s |\n", message);
    }
}