package multithreaded.fizzbuzz;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread fizzThread = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread buzzThread = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread fizzBuzzThread = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzBuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread numberThread = new Thread(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();
        

    }

    static class FizzBuzz {
        Lock lock = new ReentrantLock();
        private final int n;
        private int counter = 1;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (true) {
                lock.lock();
                if (counter > n) {
                    lock.unlock();
                    break;
                }
                if (counter % 3 == 0 && counter % 5 != 0) {
                    printFizz.run();
                    counter++;
                }
                lock.unlock();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (true) {
                lock.lock();
                if (counter > n) {
                    lock.unlock();
                    break;
                }
                if (counter % 3 != 0 && counter % 5 == 0) {
                    printBuzz.run();
                    counter++;
                }
                lock.unlock();
            }

        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true) {
                lock.lock();
                if (counter > n) {
                    lock.unlock();
                    break;
                }
                if (counter % 3 == 0 && counter % 5 == 0) {
                    printFizzBuzz.run();
                    counter++;
                }
                lock.unlock();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                lock.lock();
                if (counter > n) {
                    lock.unlock();
                    break;
                }
                if (counter % 3 != 0 && counter % 5 != 0) { // 16
                    printNumber.accept(counter);
                    counter++;
                }
                lock.unlock();
            }
        }
    }
}
