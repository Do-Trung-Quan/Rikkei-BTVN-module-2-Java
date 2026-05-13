package ex03;

public class ex03 {
    public class Animal{
        protected String name;
        protected int age;

        public Animal(String name,int age){
            this.name=name;
            this.age=age;
        }

        public void makeSound(){
            System.out.println("Animal is making sound");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public class Cat extends Animal{
        private String breed;
        public Cat(String name,int age,String breed){
            super(name,age);
            this.breed=breed;
        }
        public void meow() {
            System.out.println(name + " is meowing: Meo meo!");
        }

        public String getBreed() {
            return breed;
        }
        public void setBreed(String breed) {
            this.breed = breed;
        }
    }

    public class Dog extends Animal{
        private String color;
        public Dog(String name,int age,String color){
            super(name,age);
            this.color=color;
        }

        public void bark() {
            System.out.println(name + " is barking: Gâu gâu!");
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
    }
}
