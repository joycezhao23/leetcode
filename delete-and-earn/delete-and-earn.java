class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> dedup = new ArrayList<Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                dedup.add(num);
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        Collections.sort(dedup);
        int n = dedup.size();
        int[][] dp = new int[n + 1][2];
        dp[1][1] = map.get(dedup.get(0)) * dedup.get(0);
        for (int i = 1; i < n; i++) {
            if (dedup.get(i - 1) == dedup.get(i) - 1) {
                dp[i + 1][0] = dp[i][1];
                dp[i + 1][1] = Math.max(dp[i - 1][1], dp[i - 1][0]) + map.get(dedup.get(i)) * dedup.get(i);    
            } else {
                dp[i + 1][0] = Math.max(dp[i][1], dp[i][0]);
                dp[i + 1][1] = Math.max(dp[i][1], dp[i][0]) + map.get(dedup.get(i)) * dedup.get(i);
            }
            
        }
        return Math.max(dp[n][0], dp[n][1]);
    }
}