class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int l = s1.length();
        for (int i = 0; i < l; i++) {
            count[s2.charAt(i) - 'a']--;
        }
        if (helper(count)) return true;
        for (int i = l; i < s2.length(); i++) {
            count[s2.charAt(i - l) - 'a']++;
            count[s2.charAt(i) - 'a']--;
            if (helper(count)) return true;
        }
        return false;
    }
    
    private boolean helper(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}