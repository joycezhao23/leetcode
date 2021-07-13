class Solution {
    int count = 0;
    
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), new HashSet<Integer>());
        return count;
    }
    
    private void helper(int[] nums, List<Integer> list, Set<Integer> set) {
        if (list.size() == nums.length) {
            count++;
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i) || i > 0 && nums[i] == nums[i - 1] && !set.contains(i - 1)) continue;
            if (list.size() > 0 && !isSquare(list.get(list.size() - 1) + nums[i])) continue;
            list.add(nums[i]);
            set.add(i);
            helper(nums, list, set);
            set.remove(i);
            list.remove(list.size() - 1);
        }
    }
    
    private boolean isSquare(int num) {
        int s = (int)Math.sqrt(num);
        return s * s == num;
    }
}