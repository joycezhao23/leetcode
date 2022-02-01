class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return res;
    }
}