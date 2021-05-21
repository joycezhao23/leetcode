class Solution {
    public int minInsertions(String s) {
        int res = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (right % 2 == 1) {
                    right--;
                    res++;
                }
                right += 2;
                
            } else {
                right--;
                if (right < 0) {
                    res++;
                    right += 2;
                }
            }
        }
        return res + right;
    }
}