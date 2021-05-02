class Solution {
    public String reverseOnlyLetters(String s) {
        int l = 0, r = s.length() - 1;
        StringBuilder ss = new StringBuilder(s);
        
        while (l < r) {
            if (!Character.isLetter(ss.charAt(l))) {
                l++;
            } else if (!Character.isLetter(ss.charAt(r))) {
                r--;
            } else {
                char tmp = ss.charAt(l);
                ss.setCharAt(l++, ss.charAt(r));
                ss.setCharAt(r--, tmp);
            }
        }
        return ss.toString();
    }
}