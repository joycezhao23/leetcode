class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int p1 = 0, p2 = 0, n1 = slots1.length, n2 = slots2.length;
        List<Integer> res = new ArrayList<Integer>();
        while (p1 < n1 && p2 < n2) {
            int l = Math.max(slots1[p1][0], slots2[p2][0]);
            int r = Math.min(slots1[p1][1], slots2[p2][1]);
            if (r - l >= duration) {
                res.add(l);
                res.add(l + duration);
                return res;
            }
            if (slots1[p1][1] < slots2[p2][1]) 
                p1++;
            else 
                p2++;
        }
        return res;
    }
}