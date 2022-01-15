class Solution {
    Map<Integer, List<Integer>> positions;
    Set<Integer> visited;
    Queue<Integer> q;
    
    public int minJumps(int[] arr) {
        if (arr.length == 1) return 0;
        positions = getPos(arr);
        visited = new HashSet<Integer>();
        q = new LinkedList<Integer>();
        q.add(0);
        visited.add(0);
        
        int step = 0, n = arr.length;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            while (size-- > 0) {
                int cur = q.poll();
                List<Integer> list = positions.get(arr[cur]);
                list.add(cur + 1);
                list.add(cur - 1);
                for (int i : list) {
                    if (!addPos(i, n)) return step;
                }
                list.clear();
            }
        }
        return -1;
    }
    
    private boolean addPos(int pos, int n) {
        if (pos == n - 1) return false;
        if (pos >= n || pos < 0 || visited.contains(pos)) return true;
        visited.add(pos);
        q.add(pos);
        return true;
    }
                    
        
    
    private Map<Integer, List<Integer>> getPos(int[] arr) {
        Map<Integer, List<Integer>> positions = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            positions.putIfAbsent(arr[i], new ArrayList<Integer>());
            positions.get(arr[i]).add(i);
        }
        return positions;
    }
}