class Solution {
    public int longestAwesome(String s) {
        int bit = 0, res = 0, l = 0, n = s.length();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            if ((bit & (1 << num)) > 0) {
                bit ^= (1 << num);
            } else {
                bit |= (1 << num);
            }
            map.putIfAbsent(bit, i);
            res = Math.max(res, i - map.get(bit));
            for (int j = 0; j < 10; j++) {
                int last = bit ^ (1 << j);
                res = Math.max(res, i - map.getOrDefault(last, i));
            }
        }
        return res;   
    }
}