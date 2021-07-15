class Solution {
    public int maxUniqueSplit(String s) {
        helper(s, 0, new HashSet<String>());
        return res;
    }
    
    int res = 0;
    
    private void helper(String s, int start, Set<String> set) {
        if (start == s.length()) {
            res = Math.max(res, set.size());
            return;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            if (set.contains(s.substring(start, i))) continue;
            String ss = s.substring(start, i);
            set.add(ss);
            helper(s, i, set);
            set.remove(ss);
        }
    }
}