class Solution {
    public int createSortedArray(int[] instructions) {
        int[] bits = new int[(int)1e5 + 2];
        int MOD = (int)1e9 + 7, n = instructions.length, cost = 0, m = bits.length, pos = 0;;
        
        for (int i : instructions) {
            int smaller = 0, strictSmaller = 0;
            for (int j = i + 1; j > 0; j-= (j & -j)) {
                smaller += bits[j];
            }
            for (int j = i; j > 0; j-= (j & -j)) {
                strictSmaller += bits[j];
            }
            cost = (cost + Math.min(strictSmaller, pos++ - smaller)) % MOD;
            
            for (int j = i + 1; j < m; j += (j & -j)) {
                bits[j]++;
            }
        }
        return cost;
    }
}