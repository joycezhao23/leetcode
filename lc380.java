class RandomizedSet {
    int size;
    List<Integer> list;
    Map<Integer, Integer> values;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        size = 0;
        list = new ArrayList<Integer>();
        values = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (values.containsKey(val)) return false;
        list.add(val);
        values.put(val, size++);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!values.containsKey(val)) return false;
        int pos = values.get(val);
        if (pos != size - 1) {
            int last = list.get(size - 1);
            values.put(last, pos);
            list.set(pos, last);
        } 
        list.remove(--size);
        values.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int pos = (int)(Math.random() * size);
        return list.get(pos);
    }
}
