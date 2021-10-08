class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean hasWord;
        
        public TrieNode() {
            this.children = new TrieNode[26];
        }    
        
        public TrieNode find(String word) {
            TrieNode cur = this;
            for (char c : word.toCharArray()) {
                int pos = c - 'a';
                if (cur.children[pos] == null) return null;
                cur = cur.children[pos];
            }
            return cur;
        }
    }
    
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int pos = c - 'a';
            if (cur.children[pos] == null) {
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.hasWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root.find(word);
        return node != null && node.hasWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */