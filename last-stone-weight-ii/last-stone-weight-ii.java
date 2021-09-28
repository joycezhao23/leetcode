class Solution {
    public int lastStoneWeightII(int[] stones) {
        Set<Integer> set1 = new HashSet<Integer>();
        set1.add(0);
        for (int i : stones) {
            Set<Integer> set2 = new HashSet<Integer>();
            for (int j : set1) {
                set2.add(i + j);
                set2.add(j - i);
            }
            set1 = set2;
        }
        int res = Integer.MAX_VALUE;
        for (int i : set1) {
            if (i >= 0) 
                res = Math.min(i, res);
            if (res == 0) break;
        }
        return res;
    }
}