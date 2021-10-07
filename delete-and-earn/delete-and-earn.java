class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        List<Integer> num = new ArrayList<Integer>();
        for (int n : nums) {
            if (!count.containsKey(n)) {
                num.add(n);
                count.put(n, 0);
            }
            count.put(n, count.get(n) + 1);
        }
        Collections.sort(num);
        int size = num.size();
        int[][] dp = new int[size][2];
        dp[0][1] = num.get(0) * count.get(num.get(0));
        for (int i = 1; i < size; i++) {
            int cur = num.get(i), prev = num.get(i - 1);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = (cur == prev + 1) ? (dp[i - 1][0] + cur * count.get(cur)) : (dp[i][0] + cur * count.get(cur));
        }
        return Math.max(dp[size - 1][0], dp[size - 1][1]);
    }
}