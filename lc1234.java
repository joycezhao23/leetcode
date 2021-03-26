class Solution {
    public int balancedString(String s) {
        int[] count = new int[26];
        char[] cs = s.toCharArray();
        int n = cs.length, k = n / 4;
        
        for (char c : cs) {
            count[c - 'A']++;
        }
        
        int i = 0, j = 0, res = n, q = 'Q' - 'A', w = 'W' - 'A', e = 'E' - 'A', r = 'R' - 'A';
        while (j < n) {
            count[cs[j++] - 'A']--;
            while (i < n && count[q] <= k && count[w] <= k && count[e] <= k && count[r] <= k) {
                res = Math.min(res, j - i);
                count[cs[i] - 'A']++;
                i++;
            } 
        }
        
        return res;
    }
}