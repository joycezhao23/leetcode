class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length < 2) return res;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            last = i; 
            if (last + 1 != nums[last]) {
                while (nums[last] != -1 && last + 1 != nums[last]) {
                    int tmp = nums[last];
                    nums[last] = last == i ? -1 : last + 1; 
                    last = tmp - 1;
                }    
                if (nums[last] != -1) res.add(last + 1);
                else nums[last] = last + 1;
            }
        }
        return res;
    }
}