class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n][2];
        int max = 0, last = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && 1 + dp[j][0] > dp[i][0]) {
                    dp[i][0] = 1 + dp[j][0];
                    dp[i][1] = j;
                } 
            }
            if (dp[i][0] > max) {
                max = dp[i][0];
                last = i;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        while (last != dp[last][1]) {
            res.add(nums[last]);
            last = dp[last][1];
        }
        res.add(nums[last]);
        return res;
    }
}