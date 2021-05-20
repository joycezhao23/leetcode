class Solution {
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public List<Integer> diffWaysToCompute(String s) {
        if (map.containsKey(s)) return map.get(s);
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> l1 = diffWaysToCompute(s.substring(0, i)), l2 = diffWaysToCompute(s.substring(i + 1));
                for (int n1: l1) {
                    for (int n2: l2) {
                        switch(c){
                            case '+': res.add(n1+n2);
                                break;
                            case '-': res.add(n1 - n2);
                                break;
                            case '*': res.add(n1 * n2);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(s));
        map.put(s, res);
        return res;
    }
}