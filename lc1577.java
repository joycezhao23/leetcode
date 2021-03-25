class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> squares1 = getSquares(nums1);
        Map<Long, Integer> squares2 = getSquares(nums2);
        return getTotal(squares1, nums2) + getTotal(squares2, nums1);
    }
    
    private int getTotal(Map<Long, Integer> squares, int[] nums) {
        int total = 0;
        for (Long key : squares.keySet()) {
            total += squares.get(key) * twoProduct(key, nums);
        }
        return total;
    }
    
    private int twoProduct(Long target, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (target % num == 0) res += map.getOrDefault((int)(target / num), 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }
    
    private Map<Long, Integer> getSquares(int[] nums) {
        Map<Long, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long square = (long)(nums[i]) * (long)(nums[i]);
            res.put(square, res.getOrDefault(square, 0) + 1);
        }
        return res;
    }
}