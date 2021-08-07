class Solution {
    Map<Integer, List<Integer>> map;
    Random rand;
    public Solution(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();
        rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> idxs = map.get(target);
        int idx = rand.nextInt(idxs.size());
        return idxs.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */