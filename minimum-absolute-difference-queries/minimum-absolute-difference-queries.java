class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[] count = new int[101];
        int n = nums.length, m = queries.length;
        int[][] presum = new int[n + 1][101];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
            for (int j = 1; j <= 100; j++) 
                presum[i + 1][j] = count[j];
        }
        
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int prev = -1, min = Integer.MAX_VALUE;
            int l = queries[i][0], r = queries[i][1];
            for (int j = 1; j <= 100; j++) {
                if (presum[r + 1][j] - presum[l][j] == 0)
                    continue;
                if (prev != -1 && j - prev < min)
                    min = j - prev;
                prev = j;
            }
            res[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return res;
    }
}