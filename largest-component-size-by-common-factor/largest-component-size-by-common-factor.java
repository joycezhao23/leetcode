class Solution {
    int[] parents, sizes;
    
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        parents = new int[n];
        sizes = new int[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    if (!map.containsKey(j)) {
                        map.put(j, i);
                    } else {
                        union(map.get(j), i);
                    }
                    if (!map.containsKey(num / j)) {
                        map.put(num / j, i);
                    } else {
                        union(map.get(num / j), i);
                    }  
                }            
            }    
            if (!map.containsKey(num)) {
                map.put(num, i);
            } else {
                union(map.get(num), i);
            }    
        }
        return max;
    }
    int max = 1;
    
    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px != py) {
            parents[py] = px;
            sizes[px] += sizes[py];
            max = Math.max(max, sizes[px]);    
        }
        
    }
    
    private int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
}