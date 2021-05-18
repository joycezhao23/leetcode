class Solution {
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public List<Integer> diffWaysToCompute(String s) {
        if (map.containsKey(s)) return map.get(s);
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') {
                List<Integer> l1 = diffWaysToCompute(s.substring(0, i)), l2 = diffWaysToCompute(s.substring(i + 1));
                for (int num1 : l1) {
                    for (int num2 : l2) {
                        int c = 0;
                        switch (s.charAt(i)) {
                            case '+': c = num1 + num2;
                                break;
                            case '-': c = num1 - num2;
                                break;
                            case '*': c = num1 * num2;
                                break;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(s));
        map.put(s, res);
        return res;
    }
}