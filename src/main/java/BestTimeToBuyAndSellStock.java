/**
 * Created by Prasada Rao on 09/10/21 12:09 PM
 **/
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minStockPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minStockPrice = Math.min(minStockPrice, price);
            maxProfit = Math.max(maxProfit, price - minStockPrice);
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int minStockPrice = Integer.MAX_VALUE;
        int maxStockPrice = 0;
        for (int price : prices) {
            if (minStockPrice > price) {
                minStockPrice = price;
            } else if (price - minStockPrice > maxStockPrice) {
                maxStockPrice = price - minStockPrice;
            }
        }
        return maxStockPrice;
    }

    public int maxProfit1(int[] prices) {
        int start = 0;
        int maxProfit = 0;
        while (start < prices.length) {
            int end = start + 1;
            while (end < prices.length) {
                if (prices[end] > prices[start]) {
                    maxProfit = Math.max(maxProfit, prices[end] - prices[start]);
                }
                end++;
            }
            start++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{2, 4, 1}));
    }
}
