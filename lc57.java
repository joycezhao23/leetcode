class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<int[]>();
        int start = newInterval[0], end = newInterval[1];
        boolean checking = true;
        int i = 0;
        for (int[] itv : intervals) {
            if (itv[0] > end) {
                if (checking) {
                    checking = false;
                    int[] newItv = {start, end};
                    list.add(newItv);
                }
                list.add(itv);
            } else if (itv[1] < start) {
                list.add(itv);
            } else {
                start = Math.min(start, itv[0]);
                end = Math.max(end, itv[1]);    
            }
        }
        if (checking) {
            int[] newItv = {start, end};
            list.add(newItv);
        }
        return list.toArray(new int[0][2]);
    }
}