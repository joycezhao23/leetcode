class Solution {
    int mod = 1000000007;
    
    class BIT {
        int[] bit;
        
        public BIT() {
            this.bit = new int[(int)1e5 + 1];
        }
        
        public void insert(int idx) {
            for (int i = idx; i <= (int)1e5; i += (i & -i)) bit[i]++;
        }
        
        public int query(int idx) {
            int sum = 0;
            for (int i = idx; i > 0; i -= (i & -i)) sum += bit[i];
            return sum;
        }
    }
    
    public int createSortedArray(int[] instructions) {
        BIT bit = new BIT();
        
        int cost = 0;
        for (int i = 0; i < instructions.length; i++) {
            int idx = instructions[i];
            int less = bit.query(idx - 1);
            int more = i - bit.query(idx);
            cost = (cost + Math.min(less, more)) % mod;
            bit.insert(idx);
        }
        
        return cost;
    }   
}