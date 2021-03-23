class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0, max = 0;
        
        for (int i = 0, diff = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            } else {
                diff += customers[i];
            }
            if (i >= X) {
                diff -= grumpy[i - X] * customers[i - X];
            }
            max = Math.max(max, diff);
        }
        
        return total + max;
    }
}