class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, n = s.length(), prev = 0;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                while (s.charAt(prev) != c) {
                    set.remove(s.charAt(prev));
                    prev++;
                }
                prev++;
            }
            set.add(c);
            max = Math.max(i - prev + 1, max);
        }
        return max;
    }
}