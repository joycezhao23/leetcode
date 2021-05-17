class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        
        for (String s : words) {
            int best = 0;
            for (int i = 0; i < s.length(); i++) {
                String prev = s.substring(0, i) + s.substring(i+1);
                best = Math.max(best, map.getOrDefault(prev, 0) + 1);
            }
            map.put(s, best);
            res = Math.max(res, best);
        }
        
        return res;
    }
}