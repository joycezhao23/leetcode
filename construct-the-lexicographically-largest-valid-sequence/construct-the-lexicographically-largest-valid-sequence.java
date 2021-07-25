class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        helper(0, n, res, new HashSet<Integer>());
        return res;
    }
    
    private boolean helper(int pos, int n, int[] res, Set<Integer> visited) {
        if (pos == res.length) return true;
        if (res[pos] != 0) return helper(pos + 1, n, res, visited);
        
        for (int i = n; i >= 1; i--) {
            if (visited.contains(i)) continue;
            visited.add(i);
            res[pos] = i;
            if (i == 1) {
                if(helper(pos + 1, n, res, visited)) return true;
            } else if (pos + i < res.length && res[pos + i] == 0) {
                res[pos + i] = i;
                if(helper(pos + 1, n, res, visited)) return true;
                res[pos + i] = 0;
            }
            res[pos] = 0;
            visited.remove(i);
        }
        return false;
    }
}