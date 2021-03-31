class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length, l = 1, r = piles[n - 1];
        if (h == n) return r;
        
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (canEatAll(piles, h, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        
        if (l < r && canEatAll(piles, h, l)) return l;
        return r;
    }
    
    private boolean canEatAll(int[] piles, int h, int speed) {
        int count = 0;
        for (int pile : piles) {
            count += (pile + speed - 1) / speed;
        }
        return count <= h;
    }
}