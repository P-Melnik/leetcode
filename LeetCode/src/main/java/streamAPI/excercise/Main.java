package streamAPI.excercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Trader raul = new Trader("Raul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raul, 2012, 1000),
                new Transaction(raul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 450)
        );

        // Find all for 2011 and sort by sum

        List<Transaction> transactions2011 = transactionList.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();

        transactions2011.forEach(System.out::println);
        System.out.println();

        // Print list of distinct cities

        List<String> cities = transactionList.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().toList();

        System.out.println(cities);

        // Find all traders from Cambridge and sort by name

        List<Trader> tradersFromCambridge = transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName)).distinct()
                .toList();

        System.out.println();
        System.out.println(tradersFromCambridge);

        // Return String with all traders names and sort

        List<String> names = transactionList.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .toList();

        System.out.println();
        System.out.println(names);

        // Is there anyone from Milan

        Optional<Trader> optionalTrader = transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .findAny();

        System.out.println();
        System.out.println(optionalTrader.isPresent());

        // Print sum of all transactions from Cambridge

        List<Integer> sum = transactionList.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .toList();

        System.out.println(sum);

        // What is the max transaction

        Optional<Integer> maxTransaction = transactionList.stream()
                .max(Comparator.comparing(Transaction::getValue))
                        .map(Transaction::getValue);

        System.out.println();
        System.out.println("maxTransaction: " + maxTransaction.get());

        // What is the min transaction

        Optional<Integer> minTransaction = transactionList.stream()
                .min(Comparator.comparing(Transaction::getValue))
                        .map(Transaction::getValue);

        System.out.println();
        System.out.println("minTransaction: " + minTransaction.get());
    }
}
