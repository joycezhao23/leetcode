class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] t1 = new int[n + 1], t2 = new int[n + 1];
        for (int[] t : trust) {
            t1[t[0]]++;
            t2[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (t1[i] == 0 && t2[i] == n - 1)
                return i;
        }
        return -1;
    }
}