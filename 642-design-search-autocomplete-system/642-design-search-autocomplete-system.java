class AutocompleteSystem {
    class TrieNode {
        TrieNode[] children;
        Map<String, Integer> map;
        public TrieNode() {
            this.children = new TrieNode[128];
            this.map = new HashMap<String, Integer>();
        }
    }
    
    class Pair {
        String s;
        int count;
        public Pair(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    TrieNode root;
    String prefix;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        this.root = new TrieNode();
        this.prefix = "";
        for (int i = 0; i < times.length; i++)
            add(sentences[i], times[i]);
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        
        prefix = prefix + c;
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (cur.children[ch] == null)
                return new ArrayList<String>();
            cur = cur.children[ch];
        }
        
        return getTop3(cur);
    }
    
    private List<String> getTop3(TrieNode node) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(3, (a, b) -> a.count == b.count ? b.s.compareTo(a.s) : a.count - b.count);
        for(Map.Entry<String, Integer> entry : node.map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        List<String> res = new ArrayList<String>();
        while(!pq.isEmpty()) {
            res.add(pq.poll().s);
        }
        Collections.reverse(res);
        return res;
    }
    
    private void add(String s, int t) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c] == null) 
                cur.children[c] = new TrieNode();
            cur = cur.children[c];
            cur.map.put(s, cur.map.getOrDefault(s, 0) + t);
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */