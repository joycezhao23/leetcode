class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer>[] map = new List[4];
        for (int i = 1; i <= 3; i++)
            map[i] = new ArrayList<Integer>();
        for (int i = 0; i < colors.length; i++)
            map[colors[i]].add(i);
        List<Integer> res = new ArrayList<Integer>();
        for (int[] q : queries) {
            res.add(helper(q[0], map[q[1]]));
        }
        return res;
    }
    
    private int helper(int idx, List<Integer> list) {
        if (list.size() == 0) 
            return -1;
        int l = 0, r = list.size() - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) > idx) {
                r = mid;
            } else if (list.get(mid) == idx) {
                return 0;
            } else {
                l = mid;
            }
        }
        return Math.min(Math.abs(list.get(l) - idx), Math.abs(list.get(r) - idx));
        // if (l > 0)
        //     res = Math.min(res, Math.abs(list.get(l - 1) - idx));
        // if (r < list.size() - 1)
        //     res = Math.min(res, Math.abs(list.get(r + 1) - idx));
        // return res;
    }
}