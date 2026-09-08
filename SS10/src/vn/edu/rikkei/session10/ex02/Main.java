package vn.edu.rikkei.session10.ex02;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- MÔ PHỎNG ÂM THANH ĐỘNG VẬT ---");
        System.out.println("Dog: \"Rex\"");
        System.out.println("Cat: \"Mimi\"\n");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             MÔ PHỎNG HÀNH VI SINH HỌC RIKKEI          |");
        System.out.println("+-------------------------------------------------------+");

        Dog dog = new Dog("Rex");
        Cat cat = new Cat("Mimi");

        dog.makeSound();
        cat.makeSound();

        System.out.println("+-------------------------------------------------------+");
    }
}