class Solution {
    public int maxLength(List<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            helper(i, new HashSet<Character>(), arr);    
        }
        
        return res;
    }
    int res = 0;
    
    private void helper(int pos, Set<Character> seen, List<String> arr) {
        String s = arr.get(pos);
        Set<Character> cur = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            if (seen.contains(c) || cur.contains(c))
                break;
            cur.add(c);
        }
        if (cur.size() != s.length()) 
            return;
        res = Math.max(res, seen.size() + cur.size());
        Set<Character> set = new HashSet<Character>();
        set.addAll(seen);
        set.addAll(cur);
        for (int i = pos + 1; i < arr.size(); i++) {
            helper(i, set, arr);
        }
    }
}