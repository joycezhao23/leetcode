class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(new StringBuilder(), n, n, res);
        return res;
    }
    
    private void helper(StringBuilder sb, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        
        if (left < 0 || right < 0 || right < left)
            return;
        sb.append("(");
        helper(sb, left - 1, right, res);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        helper(sb, left, right - 1, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}