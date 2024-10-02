// AnimalFactory.java
interface Animal {
    void sound();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

class AnimalFactory {
    public static Animal createAnimal(String type) {
        if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        return null;
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Animal dog = AnimalFactory.createAnimal("dog");
        dog.sound();

        Animal cat = AnimalFactory.createAnimal("cat");
        cat.sound();
    }
}
