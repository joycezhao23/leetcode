class Solution {
    class Tuple {
        int d, p, v;
        public Tuple(int num) {
            this.d = num / 100;
            this.p = (num - d * 100) / 10;
            this.v = num % 10;
        }
    }
    
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 1, n = nums.length, count = 0;
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.add(new Tuple(nums[0]));
        
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int next = (t.d + 1) * 10 + t.p * 2;
            
            if (i >= n || nums[i] / 10 > next) {
                count += t.v;
                continue;
            }
            
            while (i < n && nums[i] / 10 <= next) {
                Tuple child = new Tuple(nums[i++]);
                child.v = child.v + t.v;
                q.add(child);
            }
        }
        return count;
    }
}