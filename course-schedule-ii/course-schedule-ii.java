class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] map1 = new HashSet[numCourses];
        Set<Integer>[] map2 = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map1[i] = new HashSet<Integer>();
            map2[i] = new HashSet<Integer>();
        }
        for (int[] p : prerequisites) {
            map1[p[0]].add(p[1]);
            map2[p[1]].add(p[0]);
        }
        int[] res = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) { 
            if (map1[i].size() == 0) {
                q.add(i);
            }
        }
        int idx = 0, count = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            res[idx++] = course;
            count++;
            for (int next : map2[course]) {
                map1[next].remove(course);
                if (map1[next].isEmpty()) {
                    q.add(next);
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }
}