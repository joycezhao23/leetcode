class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int l = 1, r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (getDays(weights, mid) > D) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    
    private int getDays(int[] weights, int cap) {
        int curr = 0, days = 0;
        for (int w : weights) {
            if (curr + w > cap) {
                days++;
                curr = 0;
            }
            curr += w;
        }
        if (curr > 0) days++;
        return days;
    }
}