class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        remove(0, 0, s, res, '(', ')');
        return res;
    }
    
    private void remove(int i, int j, String s, List<String> res, char open, char close) {
        int stack = 0;
        for (; j < s.length(); j++) {
            if (s.charAt(j) == open) {
                stack++;
            } else if (s.charAt(j) == close) {
                stack--;
                if (stack < 0) break;
            }
        }
        
        if (stack < 0) {
            for (; i <= j; i++) {
                if (s.charAt(i) != close) continue;
                if (i > 1 && s.charAt(i) == s.charAt(i - 1)) continue;
                remove(i, j, s.substring(0, i) + s.substring(i + 1), res, open, close);
            }    
        } else if (stack > 0) {
            remove(0, 0, new StringBuilder(s).reverse().toString(), res, close, open);
        } else {
            if (open == '(') res.add(s);
            else res.add(new StringBuilder(s).reverse().toString());
        }
        
    }
}