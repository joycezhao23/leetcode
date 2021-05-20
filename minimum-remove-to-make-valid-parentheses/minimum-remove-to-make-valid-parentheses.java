class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '(') {
                l++;
            } else if (sb.charAt(i) == ')') {
                r++;
                if (l < r) {
                    sb.setCharAt(i, '#');
                    r--;
                }
            }
        }
        
        l = r = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sb.charAt(i) == '#') {
                sb.deleteCharAt(i);
            } else if (sb.charAt(i) == ')') {
                r++;
            } else if (sb.charAt(i) == '(') {
                l++;
                if (l > r) {
                    sb.deleteCharAt(i);
                    l--;
                }
            }
        }
        
        return sb.toString();
    }
}