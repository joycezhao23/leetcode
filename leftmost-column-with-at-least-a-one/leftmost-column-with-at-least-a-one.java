/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int m = dim.get(0), n = dim.get(1);
        int r = n - 1;
        boolean found = false;
        for (int i = 0; i < m; i++) {
            int lm = helper(binaryMatrix, i, 0, r);
            if (lm != -1) {
                r = lm;
                found = true;
            }
            if (r == 0) break;
        }
        return found ? r : -1;
    }
    
    private int helper(BinaryMatrix b, int row, int l, int r) {
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (b.get(row, mid) == 1) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (b.get(row, l) == 1) return l;
        if (b.get(row, r) == 1) return r;
        return -1;
    }
}