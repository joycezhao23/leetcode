class Solution {
    public int openLock(String[] deadends, String target) {
        int t = Integer.valueOf(target);
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < deadends.length; i++) visited.add(Integer.valueOf(deadends[i]));
        if (visited.contains(0)) {
            return t == 0? 0 : -1;
        }
        
        visited.add(0);
        q.add(0);
                
        int step = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == t) return step;   
                for (int next : nexts(cur)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            step++;
        }
        return -1;
    }
    
    private int[] nexts(int a) {
        int[] res = new int[8];
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = a % 10;
            a /= 10;
        }
        for (int i = 0; i < 4; i++) {
            int tmp = digits[i], d1 = (digits[i] + 1) % 10, d2 = (digits[i] + 9) % 10;
            digits[i] = d1;
            res[2*i] = getInt(digits);
            digits[i] = d2;
            res[2 * i + 1] = getInt(digits);
            digits[i] = tmp;
        }
        return res;
    }
    private int getInt(int[] digits) {
        int res = 0;
        for (int i = 3; i >= 0; i--) {
            res = res * 10 + digits[i];
        }
        return res;
    }
}