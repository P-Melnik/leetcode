package patterns.abstractFactoryCars;

interface CarsFactory {

    Sedan createSedan();
    Coupe createCoupe();

}

class SkodaCarsFactory implements CarsFactory {

    @Override
    public Sedan createSedan() {
        return new SkodaSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new SkodaCoupe();
    }
}

class FordCarsFactory implements CarsFactory {

    @Override
    public Sedan createSedan() {
        return new FordSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new FordCoupe();
    }
}


//class CarsFactoryImpl implements CarsFactory {
//    CarType type;
//
//    CarsFactoryImpl(CarType type) {
//        this.type = type;
//    }
//
//
//    @Override
//    public Sedan createSedan() {
//        switch (type) {
//            case FORD -> {
//                return new FordSedan();
//            }
//            case SKODA -> {
//                return new SkodaSedan();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Coupe createCoupe() {
//        switch (type) {
//            case FORD -> {
//                return new FordCoupe();
//            }
//            case SKODA -> {
//                return new SkodaCoupe();
//            }
//        }
//        return null;
//    }
//
//}

class TestDrive {
    CarsFactory factory;

    TestDrive(CarType type) {
        switch (type) {
            case SKODA -> {
                this.factory = new SkodaCarsFactory();
            }
            case FORD -> {
                this.factory = new FordCarsFactory();
            }
        }
    }

    public void testDrive() {
        Sedan sedan = factory.createSedan();
        Coupe coupe = factory.createCoupe();
        coupe.driveCoupe();
        sedan.driveSedan();
    }
}

public class Main {
    public static void main(String[] args) {

        TestDrive testDrive = new TestDrive(CarType.FORD);

        testDrive.testDrive();

        TestDrive testDrive1 = new TestDrive(CarType.SKODA);

        testDrive1.testDrive();
    }
}




