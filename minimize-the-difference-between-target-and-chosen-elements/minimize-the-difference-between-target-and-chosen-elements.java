class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(0);
        for (int[] arr : mat) {
            Set<Integer> next = new HashSet<Integer>();
            int minBig = Integer.MAX_VALUE;
            for (int i : set) {
                for (int j : arr) {
                    int num = i + j;
                    if (num > target) {
                        if (num < minBig) {
                            minBig = num;
                            next.add(num);
                        }
                    } else {
                        next.add(num);    
                    }                    
                }
            }
            set = next;
        }
        int diff = Integer.MAX_VALUE;
        for (int i : set) {
            if (Math.abs(target - i) < diff) {
                diff = Math.abs(target - i);
            }
        }
        return diff;
    }
}