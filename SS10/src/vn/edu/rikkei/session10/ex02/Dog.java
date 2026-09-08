package vn.edu.rikkei.session10.ex02;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        String message = "[Dog " + getName() + "]  says: Woof! Woof!";
        System.out.printf("| %-53s |\n", message);
    }
}