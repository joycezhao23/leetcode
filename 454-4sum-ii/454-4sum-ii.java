class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = twoSum(nums3, nums4);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int left = 0 - nums1[i] - nums2[j];
                count += map.getOrDefault(left, 0);
            }
        }
        return count;
    }
    
    private Map<Integer, Integer> twoSum(int[] n1, int[] n2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                int sum = n1[i] + n2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map;
    }
}