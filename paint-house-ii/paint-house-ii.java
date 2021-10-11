class Solution {
    public int minCostII(int[][] costs) {
        int houses = costs.length, colors = costs[0].length;
        int idx1 = 0, idx2 = 0, min1 = 0, min2 = 0;
        for (int i = 1; i <= houses; i++) {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, i1 = -1, i2 = -1;
            for (int j = 0; j < colors; j++) {
                int cost = costs[i-1][j] + (j == idx1 ? min2 : min1);
                if (cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    i2 = i1;
                    i1 = j;
                } else if (cost < m2) {
                    m2 = cost;
                    i2 = j;
                }
            }
            idx1 = i1;
            idx2 = i2;
            min1 = m1;
            min2 = m2;
        }
        return min1;
    }
}