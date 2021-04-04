class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double l = 0.0, r = (double)stations[stations.length - 1], t = Math.pow(10, -6);
        while (l + t < r) {
            double mid = l + (r - l) / 2;
            if (getStations(stations, mid) > k) {
                l = mid;
            } else {
                r = mid;
            }
        }
        
        if (getStations(stations, l) <= k) return l;
        return r;
    }
    
    private int getStations(int[] ss, double dist) {
        int count = 0;
        for (int i = 0; i < ss.length - 1; i++) {
            count += (int)Math.ceil((ss[i + 1] - ss[i]) / dist) - 1;
        }
        return count;
    }
}