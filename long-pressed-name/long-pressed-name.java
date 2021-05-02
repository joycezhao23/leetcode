class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0, n = name.length(), m = typed.length();
        while (i < n && j < m) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        if (i != n) return false;
        while (j < m && typed.charAt(j) == name.charAt(n - 1)) j++;
        return j == m;
    }
}