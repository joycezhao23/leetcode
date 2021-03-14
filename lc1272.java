class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] itv : intervals) {
            if (itv[1] <= toBeRemoved[0] || itv[0] >= toBeRemoved[1]) {
                addList(itv[0], itv[1], res);
            } else {
                if (itv[0] < toBeRemoved[0]) {
                    addList(itv[0], toBeRemoved[0], res);           
                }
                if (itv[1] > toBeRemoved[1]) {
                    addList(toBeRemoved[1], itv[1], res);           
                }
            }
        }
        return res;
    }
    
    private void addList(int start, int end, List<List<Integer>> res) {
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(start);
        ls.add(end);
        res.add(ls);
    }
}