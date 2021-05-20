class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lo++;
                hi++;
            } else if (s.charAt(i) == ')') {
                hi--;
                if (lo > 0) lo--;
            } else {
                hi++;
                if (lo > 0) lo--;
            }
            if (hi < 0) return false;
        }
        return lo == 0;
    }
}