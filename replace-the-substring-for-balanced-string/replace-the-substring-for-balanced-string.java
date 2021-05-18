class Solution {
    public int balancedString(String s) {
        int n = s.length(), res = n, limit = n / 4, i = 0, j;
        int q = 'Q' - 'A', w = 'W' - 'A', e = 'E' - 'A', r = 'R' - 'A';
        int[] count = new int[26];
        
        for (int k = 0; k < n; k++) {
            count[s.charAt(k) - 'A']++;
        }
        
        for(j = 0; j < n; j++) {
            char c = s.charAt(j);
            count[c - 'A']--;
            while (i < n && count[q] <= limit && count[w] <= limit && count[e] <= limit && count[r] <= limit) {
                res = Math.min(res, j - i + 1);
                count[s.charAt(i++) - 'A']++;
            }
        }
        return res;
    }
}