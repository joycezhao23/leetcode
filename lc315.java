# Binary index tree

class Solution {
    class BIT {
        int[] counts;
        int size;
        public BIT(int size) {
            this.counts = new int[size + 1];
            this.size = size;
        }
        
        public void update(int index, int delta) {
            for (int i = index; i <= size; i += (i & -i)) counts[i] += delta;
        }
        
        public int query(int index) {
            int sum = 0;
            for (int i = index; i > 0; i -= (i & -i)) sum += counts[i];
            return sum;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i : nums) set.add(i);
        
        int rank = 0;
        Map<Integer, Integer> ranks = new HashMap<Integer, Integer>();
        for (Integer val : set) ranks.put(val, ++rank);
        
        BIT tree = new BIT(set.size());
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = ranks.get(nums[i]);
            res.add(tree.query(index - 1));
            tree.update(index, 1);
        }
        
        Collections.reverse(res);
        return res;
    }
}