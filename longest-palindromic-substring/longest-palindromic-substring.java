class Solution {
    public String longestPalindrome(String s) {
        int start = 0, size = 1, n = s.length();
        boolean[][] pal = new boolean[n][n];
        for (int i = 0; i < n; i++) pal[i][i] = true;
        for (int i = 0; i < n - 1; i++) {
            pal[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (pal[i][i + 1]) {
                start = i;
                size = 2;
            }
        }
        for (int l = 2; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                pal[i][i + l] = pal[i + 1][i + l - 1] && s.charAt(i) == s.charAt(i+l);
                if (pal[i][i + l] && l > size - 1) {
                    start = i;
                    size = l + 1;
                }
            }
        }
        return s.substring(start, start + size);
    }
}