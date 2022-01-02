class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int total = 0;
        for (int t : time) {
            int tt = t % 60;
            total += count[(60 - tt) % 60];
            count[tt]++;
        }
        return total;
    }
}