package patterns.strategy;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Player> players = List.of(new Player(), new Player(),
                new Player(), new Player());

        Dealer dealer = new Dealer(new BlackJack());

        Table table = new Table(players, dealer);
        table.deal();

        players.forEach(System.out::println);

        dealer.setDealStrategy(new Poker());
        table.deal();

        players.forEach(System.out::println);

    }
}

interface DealStrategy {
    void deal(Player player, List<Integer> cards);
}

class BlackJack implements DealStrategy {
    Random random = new SecureRandom();

    @Override
    public void deal(Player player, List<Integer> cards) {
        for (int i = 0; i < 2; i++) {
            int card = random.nextInt(1, cards.size());
            player.add(cards.remove(card));
        }
    }
}

class Poker implements DealStrategy {
    Random random = new SecureRandom();

    @Override
    public void deal(Player player, List<Integer> cards) {
        for (int i = 0; i < 4; i++) {
            int card = random.nextInt(1, cards.size());
            player.add(cards.remove(card));
        }
    }
}

class Dealer {
    List<Integer> cards;
    DealStrategy dealStrategy;

    Dealer(DealStrategy dealStrategy) {
        setDealStrategy(dealStrategy);
        clear();
    }

    void deal(Player player) {
        dealStrategy.deal(player, cards);

    }

    void setDealStrategy(DealStrategy dealStrategy) {
        this.dealStrategy = dealStrategy;
    }

    void clear() {
        cards = new LinkedList<>();
        for (int i = 1; i < 53; i++) {
            cards.add(i);
        }
    }
}

class Player {

    private final List<Integer> cards = new LinkedList<>();

    void clear() {
        cards.clear();
    }

    void add(int n) {
        cards.add(n);
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + cards +
                '}';
    }
}

class Table {
    private final List<Player> players;
    private final Dealer dealer;

    Table(List<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    void deal() {
        dealer.clear();
        for (Player player : players) {
            player.clear();
            dealer.deal(player);
        }
    }
}
