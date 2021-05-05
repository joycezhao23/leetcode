class Solution {
    public boolean isPalindrome(String s) {
        char[] cs = s.strip().toLowerCase().toCharArray();
        int l = 0, r = cs.length - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(cs[l])) {
                l++;
            } else if (!Character.isLetterOrDigit(cs[r])) {
                r--;
            } else if (cs[l] != cs[r]) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}