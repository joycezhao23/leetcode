class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            int tmp = max | (1 << i);
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                int left = num & mask;
                if (set.contains(left ^ tmp)) {
                    max = tmp;
                    break;
                } else {
                    set.add(left);
                }
            }
        }
        return max;
    }
}