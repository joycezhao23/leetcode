class Solution {
    public int myAtoi(String s) {
        long res = 0;
        int i = 0, n = s.length(), max = Integer.MAX_VALUE, min = Integer.MIN_VALUE, mul = 1;
        while (i < n) {
            if (Character.isDigit(s.charAt(i))) break;
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                mul = s.charAt(i) == '+' ? 1 : -1;
                i++;
                break;
            } else if (s.charAt(i) != ' ') {
                return 0;
            }
            i++;
        }
        
        while (i < n) {
            if (!Character.isDigit(s.charAt(i))) break;
            res = res * 10 + s.charAt(i++) - '0';
            if (res > max) break;
        }
        
        res *= mul;
        if (res > max) return max;
        if (res < min) return min;
        
        return (int)res;
    }
}