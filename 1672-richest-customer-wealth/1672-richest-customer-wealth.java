class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int w = 0;
            for (int j = 0; j < accounts[0].length; j++)
                w += accounts[i][j];
            max = Math.max(max, w);
        }
        return max;
    }
}