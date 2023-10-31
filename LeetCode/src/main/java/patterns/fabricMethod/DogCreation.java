package patterns.fabricMethod;

public class DogCreation extends Create {

    Alive create() {
        return new Dog();
    }
}
