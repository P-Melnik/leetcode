package streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String s = "I am going to go for a walk and I am hoping to see some nice places";
        List<String> words = Arrays.asList(s.split(" "));

        long count = words.stream().filter(w -> w.length() > 2).count();

        System.out.println(count);

        List<String> s1 = words.stream().sorted(Comparator.comparing(String::length)
                .reversed()).toList();

        System.out.println(s1);

        Object[] powers = Stream.iterate(1.0, x -> x * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20)
                .toArray();

    }
}

