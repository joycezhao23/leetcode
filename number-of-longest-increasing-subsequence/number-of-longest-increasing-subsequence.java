class Solution {
    public int findNumberOfLIS(int[] nums) {
        int count = 0, max = 0, n = nums.length;
        TreeMap<Integer, int[]> map = new TreeMap<Integer, int[]>();
        map.put(Integer.MIN_VALUE, new int[]{0, 1});
        for (int i : nums) {
            int r = 0, c = 0;
            Map.Entry<Integer, int[]> cur = map.lowerEntry(i);
            while (cur != null) {
                if (cur.getValue()[0] + 1 > r) {
                    r = cur.getValue()[0] + 1;
                    c = cur.getValue()[1];
                } else if (cur.getValue()[0] + 1 == r) {
                    c += cur.getValue()[1];
                }
                cur = map.lowerEntry(cur.getKey());
            }
            if (r > max) {
                max = r;
                count = c;
            } else if (r == max) {
                count += c;
            }
            int[] cura = map.get(i);
            if (cura == null || cura[0] < r) {
                map.put(i, new int[]{r, c});    
            } else {
                map.put(i, new int[]{r, c + cura[1]});
            }
            
        }
        return count;
    }
}