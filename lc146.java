class LRUCache {
    class Node {
        Node prev, next;
        int key, val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    class DoubleLL {
        Node head, tail;
        public DoubleLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }
        
        public void add(Node node) {
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            node.next = tail;
        }
        
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = node.next = null;
        }
        
        public void moveToTail(Node node) {
            remove(node);
            add(node);
        }
        
        public Node removeFirst() {
            Node first = head.next;
            head.next = first.next;
            first.next.prev = head;
            return first;
        }
    }
    
    Map<Integer, Node> values;
    int cap;
    DoubleLL dll;
    
    public LRUCache(int capacity) {
        values = new HashMap<Integer, Node>();
        cap = capacity;
        dll = new DoubleLL();
    }
    
    public int get(int key) {
        if (!values.containsKey(key)) return -1;
        Node node = values.get(key);
        dll.moveToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (values.containsKey(key)) {
            Node node = values.get(key);
            node.val = value;
            dll.moveToTail(node);
        } else {
            Node node = new Node(key, value);
            values.put(key, node);
            dll.add(node);
            if (values.size() > cap) {
                Node first = dll.removeFirst();
                values.remove(first.key);
            }
        } 
    }
}
