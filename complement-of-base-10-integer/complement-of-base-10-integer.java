class Solution {
    public int bitwiseComplement(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += ((1 - (n & 1)) << i);
            n = (n >> 1);
            if (n == 0) break;
        }
        return res;
    }
}