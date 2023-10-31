package patterns.abstractFactoryCars;

public class FordSedan implements Sedan {

    public void driveSedan() {
        System.out.println("ford sedan drives");
    }
}

class FordCoupe implements Coupe {

    public void driveCoupe() {
        System.out.println("ford coupe drives");
    }
}
