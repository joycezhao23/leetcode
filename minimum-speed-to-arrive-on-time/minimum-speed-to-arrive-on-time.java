class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length, max = 0;
        if (hour <= n - 1) return -1;
        
        for (int d : dist) max = Math.max(max, d);
        int lo = 1, hi = max, mid;
        double decimalHour = hour - (int) hour;
        if (decimalHour > 0) hi += (int) Math.ceil(dist[n - 1] / decimalHour);
        
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (time(dist, mid) > hour) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return time(dist, lo) <= hour ? lo : hi;
    }
    
    private double time(int[] dist, int speed) {
        double res = 0.0;
        int n = dist.length;
        for (int i = 0; i < n - 1; i++) {
            res += Math.ceil(dist[i] / (double) speed);
        }
        return res + dist[n - 1] / (double) speed;
    }
}