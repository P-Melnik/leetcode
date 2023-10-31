package patterns.fabricMethod;

public class Main {
    public static void main(String[] args) {

        Alive alive1 = new CatCreation().create();
        Alive alive2 = new DogCreation().create();


        alive1.eat();
        alive1.sleep();

        alive2.eat();
        alive2.sleep();


    }
}
