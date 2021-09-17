class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int m = requests.length, res = 0;
        
        for (int i = 1; i < (1 << m); i++) {
            int[] count = new int[n];
            
            for (int j = 0; j < m; j++) {
                if (((1 << j) & i) != 0) {
                    count[requests[j][0]]--;
                    count[requests[j][1]]++;
                }
            }
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (count[j] != 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) res = Math.max(res, Integer.bitCount(i));
        }
        
        return res;
    }
}