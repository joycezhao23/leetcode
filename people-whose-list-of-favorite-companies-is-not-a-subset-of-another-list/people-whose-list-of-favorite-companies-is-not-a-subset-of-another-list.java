class Solution {
    public List<Integer> peopleIndexes(List<List<String>> f) {
        List<Set<String>> ls = new ArrayList<>();
        for (List<String> c : f)
            ls.add(new HashSet<String>(c));
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < ls.size(); j++) {
            Set<String> cur = ls.get(j);
            boolean shouldAdd = true;
            for (int i = res.size() - 1; i >= 0; i--) {
                Set<String> prev = ls.get(res.get(i));
                if (cur.size() > prev.size()) {
                    if (isSubset(prev, cur)) {
                        res.remove(i);
                    }
                } else if (isSubset(cur, prev)) {
                    shouldAdd = false;
                    break;
                }
            }
            if (shouldAdd) res.add(j);
        }
        return res;
    }
    
    private boolean isSubset(Set<String> s1, Set<String> s2) {
        for (String s : s1) {
            if (!s2.contains(s))
                return false;
        }
        return true;
    }
}