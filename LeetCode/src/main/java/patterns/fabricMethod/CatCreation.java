package patterns.fabricMethod;

public class CatCreation extends Create {


    @Override
    Alive create() {
        return new Cat();
    }
}
