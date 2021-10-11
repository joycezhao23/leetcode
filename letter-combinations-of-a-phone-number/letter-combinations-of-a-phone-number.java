class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) return res;
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        char[] cs = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(cs, 0, sb, res, map);
        return res;
    }
    
    private void helper(char[] cs, int idx, StringBuilder sb, List<String> res, Map<Character, char[]> map) {
        if (idx == cs.length) {
            res.add(sb.toString());
            return;
        }
        
        for (char next : map.get(cs[idx])) {
            sb.append(next);
            helper(cs, idx + 1, sb, res, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}