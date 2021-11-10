class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, a = 0, b = -1 * prices[0];
        for (int i = 1; i < n; i++) {
            int ta = Math.max(a, b + prices[i]);
            int tb = Math.max(b, a - prices[i]);
            a = ta;
            b = tb;
        }
        return Math.max(a, b);
    }
}