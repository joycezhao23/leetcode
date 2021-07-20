class Solution {
    private int res = Integer.MAX_VALUE;
    private int bucketSize;
    
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        bucketSize = n / k;
        
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sets.add(new HashSet<>());
        }
        
        helper(nums, 0, sets, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private void helper(int[] nums, int idx, List<Set<Integer>> sets, int acc) {
        if (idx == nums.length) {
            res = Math.min(res, acc);
            return;
        }
        
        Set<Set<Integer>> visited = new HashSet<>();
        
        for (Set<Integer> set : sets) {
            if (set.contains(nums[idx]) || visited.contains(set) || set.size() == bucketSize) continue;
            int diff = getDiff(set, nums[idx]);
            acc += diff;
            if (acc < res) {
                set.add(nums[idx]);    
                helper(nums, idx + 1, sets, acc);
                set.remove(nums[idx]);
            }
            acc -= diff;
            visited.add(set);
        }
    }
    
    private int getDiff(Set<Integer> set, int num) {
        if (set.size() == 0) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : set) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        if (num > max) return num - max;
        if (num < min) return min - num;
        return 0;
    }
}