class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length, l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int maxRow = 0;
            for (int i = 1; i < m; i++) 
                maxRow = mat[maxRow][mid] < mat[i][mid] ? i : maxRow;
            boolean leftIsBigger = mid - 1 >= l && mat[maxRow][mid - 1] > mat[maxRow][mid];
            boolean rightIsBigger = mid + 1 <= r && mat[maxRow][mid + 1] > mat[maxRow][mid];
            if (!leftIsBigger && !rightIsBigger) {
                return new int[]{maxRow, mid};
            } else if (leftIsBigger) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[2];
    }
}