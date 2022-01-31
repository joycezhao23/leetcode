class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> pattern = new HashMap<String, List<String>>();
        for (String s : strings) {
            String p = getPattern(s);
            if (!pattern.containsKey(p)) pattern.put(p, new ArrayList<String>());
            pattern.get(p).add(s);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> list : pattern.values()) {
            res.add(list);
        }
        return res;
    }
    
    private String getPattern(String s) {
        char[] cs = s.toCharArray();
        int shift = cs[0] - 'a';
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            sb.append((c - shift + 26) % 26);
            sb.append(",");
        }
        return sb.toString();
    }
}