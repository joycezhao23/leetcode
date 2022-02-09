class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : t.toCharArray()) {
            count[c]--;
            if (count[c] < 0) return c;
        }
        return 0;
    }
}