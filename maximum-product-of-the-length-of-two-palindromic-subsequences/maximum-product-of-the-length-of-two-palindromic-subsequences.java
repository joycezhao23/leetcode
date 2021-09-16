class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int allpos = (1 << n) - 1;
        int[] dp = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            dp[i] = palSize(s, i);
        }
        int res = 0;
        for (int i = allpos; i > 0; i--) {
            if ((dp[i] * (n - dp[i])) < res) continue;
            for (int j = allpos ^ i; j > 0; j = (j - 1) & (allpos ^ i)) {
                res = Math.max(res, dp[i] * dp[j]);
            }
        }
        return res;       
    }
    
    private int palSize(String s, int i) {
        int res = 0, l = 0, r = s.length() - 1;
        while (l <= r) {
            if ((i & (1 << l)) == 0) {
                l++;
            } else if ((i & (1 << r)) == 0) {
                r--;
            } else if (s.charAt(l) != s.charAt(r)) {
                return 0;
            } else {
                res += l++ == r-- ? 1 : 2;
            }
        }
        return res;
    }
}