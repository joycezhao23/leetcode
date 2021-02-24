class WordDictionary {
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        root.add(word, 0);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
}

class TrieNode {
    boolean hasWord;
    TrieNode[] children;
    
    public TrieNode() {
        this.hasWord = false;
        this.children = new TrieNode[26];
    }
    
    public void add(String word, int pos) {
        if (pos == word.length()) {
            hasWord = true;
            return;
        }
        
        int cc = word.charAt(pos) - 'a';
        if (children[cc] == null) {
            children[cc] = new TrieNode();
        }
        children[cc].add(word, pos + 1);
    }
    
    public boolean search(String word, int pos) {
        if (pos == word.length()) {
            return hasWord;
        }
        
        if (word.charAt(pos) == '.') {
            for (int i = 0; i < 26; i++) {
                if (children[i] == null) continue;
                if (children[i].search(word, pos + 1)) return true;
            }
            return false;
        }
        
        int cc = word.charAt(pos) - 'a';
        if (children[cc] == null) return false;
        return children[cc].search(word, pos + 1);
    }
}