class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        if (n == 0) return res;
        res[1] = 1;
        int bit = 1, i = 1;
        while (i <= n) {
            while (i < (1 << bit)) {
                if (i * 2 <= n) res[i * 2] = res[i];
                if (i * 2 + 1 <= n)res[i * 2 + 1] = res[i] + 1;
                i++;
            }
            bit++;
        }
        return res;
    }
}