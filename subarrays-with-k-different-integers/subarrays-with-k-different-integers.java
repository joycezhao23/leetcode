class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k) {
        if (k <= 0) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0, res = 0;
        for (int j = 0; j < nums.length; j++) {
            if (!map.containsKey(nums[j])) {
                k--;
                map.put(nums[j], 0);
            }
            map.put(nums[j], map.get(nums[j]) + 1);
            while(k < 0) {
                if (map.get(nums[i]) == 1) {
                    k++;
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}