class LRUCache {
    class Node {
        Node prev, next;
        int key, value;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    Map<Integer, Node> nodes;
    int cap;
    Node dummy, tail;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.nodes = new HashMap<Integer, Node>();
        this.dummy = new Node(-1, -1);
        this.tail = dummy;
    }
    
    public int get(int key) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            moveToEnd(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            moveToEnd(node);
            node.value = value;
        } else {
            Node node = new Node(key, value);
            nodes.put(key, node);
            node.prev = tail;
            tail.next = node;
            tail = node;
            if (nodes.size() > cap) {
                Node r = dummy.next;
                dummy.next = r.next;
                r.next.prev = dummy;
                nodes.remove(r.key);
            }
        }
    }
    
    private void moveToEnd(Node node) {
        if (tail == node) return;
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        tail.next = node;
        node.prev = tail;
        tail = node;
        node.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */