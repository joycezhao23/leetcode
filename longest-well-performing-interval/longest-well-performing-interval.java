class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length, res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                res = i + 1;
            } else {
                map.putIfAbsent(sum, i);
                if (map.containsKey(sum - 1)) {
                    res = Math.max(res, i - map.get(sum - 1));
                }
            }
        }
        return res;
    }
}