class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] presum = build(mat);
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = Math.max(0, i - k), b = Math.min(m - 1, i + k), l = Math.max(0, j - k), r = Math.min(n - 1, j + k);
                res[i][j] = presum[b+1][r+1] + presum[t][l] - presum[b+1][l] - presum[t][r + 1];
            }
        }
        return res;
    }
    
    private int[][] build(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] presum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                presum[i + 1][j + 1] = presum[i + 1][j] + presum[i][j + 1] - presum[i][j] + mat[i][j];
            }
        }
        return presum;
    }
}