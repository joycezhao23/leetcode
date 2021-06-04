class NumMatrix {
    int[][] bits, vals;
    int rows, cols;
    
    public NumMatrix(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        vals = new int[rows][cols];
        bits = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int delta = val - vals[row][col];
        vals[row][col] = val;
        for (int i = row + 1; i <= rows; i += (i & -i)) {
            for (int j = col + 1; j <= cols; j += (j & -j)) {
                bits[i][j] += delta;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) + sum(row1 - 1, col1 -1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
    }
    
    private int sum(int row, int col) {
        int total = 0;
        for (int i = row + 1; i > 0; i -= (i & -i)) {
            for (int j = col + 1; j > 0; j -= (j & -j)) {
                total += bits[i][j];
            }
        }
        return total;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */