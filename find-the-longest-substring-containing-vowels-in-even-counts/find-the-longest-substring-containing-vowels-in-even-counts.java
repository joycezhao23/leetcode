class Solution {
    public int findTheLongestSubstring(String s) {
        int res = 0, cur = 0;
        Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
        pos.put(0, -1);
        
        for (int i = 0; i < s.length(); i++) {
            cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1;
            pos.putIfAbsent(cur, i);
            res = Math.max(res, i - pos.get(cur));
        }
        return res;
    }
}