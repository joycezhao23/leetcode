class Solution {
    class Pair {
        int t;
        String w;
        public Pair(int t, String w) {
            this.t = t;
            this.w = w;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = build(username, timestamp, website);
        Map<String, Integer> scores = new HashMap<String, Integer>();
        String p = "";
        for (List<Pair> l : map.values()) {
            int n = l.size();
            if (n < 3) continue;
            Set<String> patterns = new HashSet<String>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        String pattern = l.get(i).w + ","+l.get(j).w+","+l.get(k).w;
                        if (patterns.contains(pattern)) continue;
                        patterns.add(pattern);
                        scores.put(pattern, scores.getOrDefault(pattern, 0) + 1);        
                        if (p.equals("") || scores.get(p) < scores.get(pattern) || (scores.get(p) == scores.get(pattern) && p.compareTo(pattern) > 0))
                            p = pattern;
                    }
                }
            }
        }
        
        String[] pl = p.split(",");
        List<String> res = new ArrayList<String>();
        for (String s : pl) res.add(s);
        return res;
    }
    
    private Map<String, List<Pair>> build(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap<String, List<Pair>>();
        for (int i = 0; i < username.length; i++) {
            String user = username[i];
            if (!map.containsKey(user))
                map.put(user, new ArrayList<Pair>());
            map.get(user).add(new Pair(timestamp[i], website[i]));
        }
        for (List<Pair> l : map.values()) {
            Collections.sort(l, (a, b) -> a.t - b.t);
        }
        return map;
    }
}