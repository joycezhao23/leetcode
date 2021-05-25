class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length, res = 0;
        int[] xors = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (xors[i] == xors[j]) {
                    res += j - i - 1;
                }
            }
        }
        return res;
    }
}