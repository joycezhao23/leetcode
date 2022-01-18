class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        int prev = -2, total = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] == 0) continue;
            int empty = i - prev - 1;
            total += (empty - 1) / 2;
            prev = i;
        }
        total += (f.length - prev - 1) / 2;
        return total >= n;
    }
}