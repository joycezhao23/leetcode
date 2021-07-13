class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<String>();
        helper(s.toCharArray(), 0, res, new StringBuilder());
        return res;
    }
    
    private void helper(char[] ss, int pos, List<String> res, StringBuilder sb) {
        if (pos == ss.length) {
            res.add(sb.toString());
            return;
        }
        
        if (Character.isDigit(ss[pos])) {
            sb.append(ss[pos]);
            helper(ss, pos + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(Character.toLowerCase(ss[pos]));
            helper(ss, pos + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toUpperCase(ss[pos]));
            helper(ss, pos + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}