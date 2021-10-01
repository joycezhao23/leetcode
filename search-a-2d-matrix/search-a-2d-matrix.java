class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = m - 1, y = 0;
        while (x >= 0 && y < n) {
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] < target) {
                y++;
            } else {
                x--;
            }
        }
        return false;
    }
}