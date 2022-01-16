class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        for (String word : wordDict) set.add(word);
        List<String> res = new ArrayList<String>();
        helper(s, 0, set, new StringBuilder(), res);
        return res;
    }
    
    private void helper(String s, int idx, Set<String> set, StringBuilder sb, List<String> res) {
        if (idx == s.length()) {
            res.add(sb.substring(0, sb.length() - 1));
            return;
        }
        
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if (!set.contains(sub)) continue;
            sb.append(sub);
            sb.append(" ");
            helper(s, i + 1, set, sb, res);
            int chars = sub.length() + 1;
            sb.delete(sb.length() - chars, sb.length());
        }
    }
}