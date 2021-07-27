class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] workers = new int[k];
        Arrays.sort(jobs);
        helper(jobs, workers, k, jobs.length - 1, 0);
        return res;
    }
    
    int res = Integer.MAX_VALUE;
    
    private void helper(int[] jobs, int[] workers, int k, int pos, int start) {
        if (pos == -1) {
            res = Math.min(res, getMax(workers));
            return;
        }
        
        Set<Integer> seen = new HashSet<Integer>();
        
        for (int i = start; i < start + k; i++) {
            int idx = i % k;
            if (seen.contains(workers[idx])) continue;
            if (res <= workers[idx] + jobs[pos]) continue;
            seen.add(workers[idx]);
            workers[idx] += jobs[pos];
            helper(jobs, workers, k, pos - 1, start + 1);
            workers[idx] -= jobs[pos];
        }
    }
    
    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) max = Math.max(max, num);
        return max;
    }
}