class Solution {
    public int longestBeautifulSubstring(String word) {
        int start = -1, cur = 0, n = word.length(), res = 0;
        String vowels = "aeiou";
        for (int i = 0; i < n; i++) {
            if (start == -1) {
                if (word.charAt(i) == 'a') {
                    start = i;
                    cur = 0;
                }
            } else {
                char c = word.charAt(i);
                int idx = vowels.indexOf(c);
                if (idx == cur || idx == cur + 1) {
                    cur = idx;
                    if (idx == 4) res = Math.max(res, i - start + 1);
                } else {
                    start = idx == 0 ? i : -1;
                    cur = 0;
                }
            }
        }
        return res;
    }
}