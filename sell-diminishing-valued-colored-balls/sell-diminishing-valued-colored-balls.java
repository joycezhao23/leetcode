class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int MOD = (int)1e9 + 7, multiply = 1, n = inventory.length, i = n - 1;
        long res = 0;
        
        while (orders > 0) {
            if (i > 0 && orders >= multiply * (inventory[i] - inventory[i - 1])) {
                res += (long)(inventory[i] - inventory[i - 1]) * (inventory[i] + inventory[i - 1] + 1) / 2 * multiply;
                res %= MOD;
                orders -= multiply++ * (inventory[i] - inventory[i - 1]);
                i--; 
            } else {
                int count = orders / multiply, left = orders - count * multiply;
                res += multiply * ((long)count * inventory[i] - (long)count * (count - 1) / 2);
                res += left * (long)(inventory[i] - count);
                orders = 0;
            }
        }
        return (int)(res % MOD);
    }
}