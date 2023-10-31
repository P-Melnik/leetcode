package patterns.abstractFactory3;

public class Main {
    public static void main(String[] args) {

        Factory factory = new RocketFactory();

        Flyable o = FlyableFactory.create(0);

        Flyable o1 = factory.create();

        o.fly();
        o1.fly();


    }
}

class FlyableFactory {

    static Flyable create(int n) {
        switch (n) {
            case 0 -> {
                return new Plane();
            }
            case 1 -> {
                return new Rocket();
            }
            case 2 -> {
                return new Helicopter();
            }
        }
        return null;
    }


}

interface Flyable {
    void fly();
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("Plane fly");
    }
}

class Rocket implements Flyable {

    public void fly() {
        System.out.println("Rocket fly");
    }
}

class Helicopter implements Flyable {

    public void fly() {
        System.out.println("Helicopter fly");
    }
}

interface Factory {

    Flyable create();
}

class PlaneFactory implements Factory {


    @Override
    public Flyable create() {
        return new Plane();
    }
}

class RocketFactory implements Factory {

    public Flyable create() {
        return new Rocket();
    }
}

class HelicopterFactory implements Factory {

    public Flyable create() {
        return new Helicopter();
    }
}



