class Solution {
    public int distinctSubseqII(String s) {
        long[] count = new long[128];
        long res = 0;
        int MOD = 1000000007;
        for (char c : s.toCharArray()) {
            long sol = (res + 1 - count[c] + MOD) % MOD;
            count[c] = (count[c] + sol) % MOD;
            res = (res + sol) % MOD;            
        }
        return (int)res;
    }
}