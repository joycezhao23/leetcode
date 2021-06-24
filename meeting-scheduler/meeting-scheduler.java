class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        List<Integer> res = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
            int l = Math.max(slots1[i][0], slots2[j][0]);
            int r = Math.min(slots1[i][1], slots2[j][1]);
            if ((long)r - l >= duration) {
                res.add(l);
                res.add(l + duration);
                break;
            }
            if (r == slots1[i][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}