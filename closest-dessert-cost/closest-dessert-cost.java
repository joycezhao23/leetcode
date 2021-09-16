class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Arrays.sort(baseCosts);
        for (int i = 0; i < baseCosts.length; i++) {
            if (i > 0 && baseCosts[i] == baseCosts[i - 1]) continue;
            helper(toppingCosts, 0, baseCosts[i], target);
        }
        return res;
    }
    
    int res = 0, diff = Integer.MAX_VALUE;
    
    private void helper(int[] arr, int pos, int total, int target) {
        int d = Math.abs(total - target);
        if (d < diff || d == diff && total < res) {
            res = total;
            diff = d;
        }
        if (pos == arr.length) return;
        for (int i = pos + 1; i <= arr.length; i++) {
            helper(arr, i, total, target);
            helper(arr, i, total + arr[pos], target);
            helper(arr, i, total + arr[pos] * 2, target);
        }
    }
}