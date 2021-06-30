class MyHashSet {
    List<Integer>[] arr;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new ArrayList[512];
    }
    
    public void add(int key) {
        if (contains(key)) return;
        int k = getKey(key);
        if (arr[k] == null) arr[k] = new ArrayList<Integer>();
        arr[k].add(key);
    }
    
    public void remove(int key) {
        int k = getKey(key);
        if (arr[k] == null) return;
        for (Integer i : arr[k]) {
            if (i == key) {
                arr[k].remove(i);
                break;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int k = getKey(key);
        return arr[k] != null && arr[k].contains(key);
    }
    
    private int getKey(int key) {
        return key % 512;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */