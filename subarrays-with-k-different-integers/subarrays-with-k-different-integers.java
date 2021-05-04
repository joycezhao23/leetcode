class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K - 1);
    }
    
    private int atMost(int[] A, int k) {
        int count = 0, i = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int j = 0; j < A.length; j++) {
            if (map.getOrDefault(A[j], 0) == 0) k--;
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            while (k < 0) {
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0) {
                    k++;
                }
                i++;
            }
            count += j - i + 1;
        }
        return count;
    }
}