class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][][] memo = new int[n][n][27];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(memo[i][j], -1);
        
        return helper(s, 0, n - 1, 26, memo);
    }
    
    private int helper(String s, int l, int r, int prev, int[][][] memo) {
        if (l >= r) return 0;
        if (memo[l][r][prev] != -1) return memo[l][r][prev];
        if (s.charAt(l) - 'a' == prev) 
            return memo[l][r][prev] = helper(s, l + 1, r, prev, memo);
        if (s.charAt(r) - 'a' == prev) 
            return memo[l][r][prev] = helper(s, l, r - 1, prev, memo);
        if (s.charAt(l) == s.charAt(r)) {
            memo[l][r][prev] = helper(s, l + 1, r - 1, s.charAt(l) - 'a', memo) + 2;
        } else {
            memo[l][r][prev] = Math.max(helper(s, l + 1, r, prev, memo), helper(s, l, r - 1, prev, memo));
        }
        return memo[l][r][prev];
    }
}