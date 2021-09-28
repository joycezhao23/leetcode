class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        for (int i : stones) {
            sum += i;
            for (int j = Math.min(1500, sum); j >= i; j--) {
                dp[j] |= dp[j - i];
            }
        }
        
        for (int i = sum / 2; i>= 0; i--) {
            if (dp[i]) {
                return sum - i - i;
            }
        }
        return -1;
    }
}