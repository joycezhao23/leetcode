class Solution {
    private boolean isValid(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.length() < p.length()) return res;
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }
        int l = p.length();
        if (isValid(count)) res.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
            count[s.charAt(i - l) - 'a']++;
            if (isValid(count))
                res.add(i - l + 1);
        }
        return res;
    }
}