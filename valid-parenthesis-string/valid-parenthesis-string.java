class Solution {
    public boolean checkValidString(String s) {
        int cmax = 0, cmin = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cmax++;
                cmin++;
            } else if (s.charAt(i) == ')') {
                cmax--;
                cmin = Math.max(cmin-1, 0);
            } else {
                cmax++;
                cmin = Math.max(cmin - 1, 0);
            }
            if (cmax < 0) return false;
        }
        return cmin == 0;
    }
}