package arraysandstrings;

public class BestTimeToBuyAndSell {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4,10};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buying = 10001;
        int selling = -1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buying) {
                buying = prices[i];
            } else continue;
            for (int j = i; j < prices.length; j++) {
                if (prices[j] > buying) {
                    selling = prices[j];
                    if (selling - buying > profit) {
                        profit = selling - buying;
                    }
                }
            }
        } return profit;
    }

}
