class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                res += 2;
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.size() > 0 ? res + 1 : res;
    }
}