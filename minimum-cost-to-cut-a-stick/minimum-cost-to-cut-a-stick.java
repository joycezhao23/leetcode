class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] arr = new int[m + 2];
        System.arraycopy(cuts, 0, arr, 1, m);
        arr[m + 1] = n;
        int[][] memo = new int[m + 2][m + 2];
        return helper(0, m + 1, arr, memo);
    }
    
    private int helper(int start, int end, int[] cuts, int[][] memo) {
        if (start + 1 >= end) return 0;
        if (memo[start][end] != 0) return memo[start][end];
        
        int res = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            res = Math.min(res, cuts[end]-cuts[start]+helper(start, i, cuts, memo)+helper(i,end,cuts,memo));
        }
        
        return memo[start][end] = res == Integer.MAX_VALUE ? 0 : res;
    }
}