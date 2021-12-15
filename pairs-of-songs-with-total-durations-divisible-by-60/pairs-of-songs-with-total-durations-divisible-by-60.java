class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[501];
        for (int i : time)
            count[i]++;
        int total = 0;
        for (int i = 1; i <= 500; i++) {
            if (count[i] == 0) continue;
            for (int j = 60; j <= i + 500; j += 60) {
                if (j - i < i) {
                    continue;
                } else if (j - i == i) {
                    total += (count[i] * (count[i] - 1)) / 2;
                } else {
                    total += count[i] * count[j - i];
                }
            }
        }
        return total;
    }
}